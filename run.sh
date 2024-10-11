#!/usr/bin/env bash
SCRIPT_DIR=$(cd "$(dirname "${BASH_SOURCE[0]}")" > /dev/null 2>&1 && pwd -P)

ver="${ver:-all}"
while [ $# -gt 0 ]; do
    case "$1" in
        --ver)
            ver="$2"
            shift
            ;;
        --*)
            echo "Illegal option $1"
            ;;
    esac
    shift $(( $# > 0 ? 1 : 0 ))
done



function genConfig() {
    rocketmq_ver="$1";

    mkdir -p "$rocketmq_ver"
    pushd "$rocketmq_ver" >/dev/null 2>&1 || exit 1
        # https://archive.apache.org/dist/rocketmq/${rocketmq_ver}/rocketmq-all-${rocketmq_ver}-bin-release.zip

        download_link="https://archive.apache.org/dist/rocketmq/${rocketmq_ver}/rocketmq-all-${rocketmq_ver}-bin-release.zip"
        # download_link=${download_link/archive.apache.org/files.m.daocloud.io/archive.apache.org};
        echo "download rocketmq-all-${rocketmq_ver}-bin-release.zip from ${download_link}"

        BrokerConfig_java="https://github.com/apache/rocketmq/raw/rocketmq-all-${rocketmq_ver}/common/src/main/java/org/apache/rocketmq/common/BrokerConfig.java"
        ProxyConfig_java="https://github.com/apache/rocketmq/raw/rocketmq-all-${rocketmq_ver}/proxy/src/main/java/org/apache/rocketmq/proxy/config/ProxyConfig.java"
        NamesrvConfig_java="https://github.com/apache/rocketmq/raw/rocketmq-all-${rocketmq_ver}/common/src/main/java/org/apache/rocketmq/common/namesrv/NamesrvConfig.java"
        ControllerConfig_java="https://github.com/apache/rocketmq/raw/rocketmq-all-${rocketmq_ver}/common/src/main/java/org/apache/rocketmq/common/ControllerConfig.java"
        JraftConfig_java="https://github.com/apache/rocketmq/raw/rocketmq-all-${rocketmq_ver}/common/src/main/java/org/apache/rocketmq/common/JraftConfig.java"

        if [ -z "${JAVA_HOME_8_X64}" ]; then
          BrokerConfig_java="${BrokerConfig_java/github.com/ghp.ci/github.com}"
          ProxyConfig_java="${ProxyConfig_java/github.com/ghp.ci/github.com}"
          NamesrvConfig_java="${NamesrvConfig_java/github.com/ghp.ci/github.com}"
          ControllerConfig_java="${ControllerConfig_java/github.com/ghp.ci/github.com}"
          JraftConfig_java="${JraftConfig_java/github.com/ghp.ci/github.com}"
        fi

        if command -v aria2c >/dev/null 2>&1; then
            aria2c --continue -x 16 -s 16 -k 1M "${download_link}"
        else
            curl -C - --retry 3 --retry-delay 1 -fSL# -O "${download_link}"
        fi
        
        unzip -qq -K -o rocketmq-all-${rocketmq_ver}-bin-release.zip

        rocketmq_path="rocketmq-${rocketmq_ver}"
        if ! test -d "${rocketmq_path}" ; then
          rocketmq_path="rocketmq-all-${rocketmq_ver}-bin-release";
        fi
        if ! test -d "${rocketmq_path}" ; then
          exit 100;
        fi

        echo "gen config for ${rocketmq_path}"

        cp -f "$SCRIPT_DIR"/target/rocketmq-default-config-0.0.1-SNAPSHOT.jar "${rocketmq_path}"/lib/

        for x in "org.apache.rocketmq.common.namesrv.NamesrvConfig:namesrv" "org.apache.rocketmq.common.BrokerConfig:broker" "org.apache.rocketmq.common.ControllerConfig:controller" "org.apache.rocketmq.proxy.config.ProxyConfig:proxy"; do
        className=$(cut -d: -f1 <<< "${x}")
        fileName=$(cut -d: -f2 <<< "${x}")
        lastName=$(echo "${className}" | rev | cut -d. -f1 | rev)
        lastName_java="${lastName}_java"
        if "${rocketmq_path}"/bin/tools.sh com.dyrnq.sca.Check ${className} >/dev/null 2>&1; then
            if [ "${fileName}" = "proxy" ]; then
                ROCKETMQ_HOME="\${ROCKETMQ_HOME}" "${rocketmq_path}"/bin/tools.sh com.dyrnq.sca.Main ${className} $SCRIPT_DIR/$rocketmq_ver/"${fileName}".json json
            else
                ROCKETMQ_HOME="\${ROCKETMQ_HOME}" "${rocketmq_path}"/bin/tools.sh com.dyrnq.sca.Main ${className} $SCRIPT_DIR/$rocketmq_ver/"${fileName}".conf conf
            fi
            ROCKETMQ_HOME="\${ROCKETMQ_HOME}" "${rocketmq_path}"/bin/tools.sh com.dyrnq.sca.Main ${className} $SCRIPT_DIR/$rocketmq_ver/"${fileName}".md md "${!lastName_java}"
        else
            echo "${className} ${rocketmq_ver} ERROR"
        fi
        done

        if [ -n "${JAVA_HOME_8_X64}" ]; then
          sed -i "s@export JAVA_HOME@export JAVA_HOME=${JAVA_HOME_8_X64}@" ${rocketmq_path}/bin/./tools.sh
        fi
        mqadmin_subcommands=$(${rocketmq_path}/bin/./mqadmin | grep '^[[:space:]]' | awk '{print $1}')
        cat </dev/null > $SCRIPT_DIR/$rocketmq_ver/mqadmin.md
        (
        echo "# mqadmin"
        echo ""
        echo "<!-- TOC -->"
        ) >> $SCRIPT_DIR/$rocketmq_ver/mqadmin.md
        
        for subcommand in $mqadmin_subcommands; do
            echo "- [${subcommand}](#${subcommand}) " >> $SCRIPT_DIR/$rocketmq_ver/mqadmin.md
        done

        (
        echo ""
        echo "<!-- /TOC -->"
        echo ""
        ) >> $SCRIPT_DIR/$rocketmq_ver/mqadmin.md

        for subcommand in $mqadmin_subcommands; do
            (
                echo ""
                echo "## ${subcommand}"
                echo ""
                echo "\`\`\`bash"
                    ${rocketmq_path}/bin/./mqadmin help ${subcommand}
                echo "\`\`\`"
            )>> $SCRIPT_DIR/$rocketmq_ver/mqadmin.md
        done

        (
        echo ""
        ) >> $SCRIPT_DIR/$rocketmq_ver/mqadmin.md
          
    rm -rf "${rocketmq_path}"
    rm -rf rocketmq-all-${rocketmq_ver}-bin-release.zip

    popd >/dev/null 2>&1 || exit 1

}



if [ "${ver}" = "all" ]; then

while read -r line ; do
    line=${line//\"/}; # remove quotes

    if [[ $line == \#* ]]; then
        continue;
    fi

#    echo $line

    genConfig "$line"
done < <(cat <<EOF
"4.9.8"
"4.9.7"
"4.9.6"
"4.9.5"
"4.9.4"
"4.9.3"
"4.9.2"
"4.9.1"
"4.9.0"
"4.8.0"
"5.0.0"
"5.1.0"
"5.1.1"
"5.1.2"
"5.1.3"
"5.1.4"
"5.2.0"
"5.3.0"
"5.3.1"
EOF
)

else
    genConfig "$ver"
fi