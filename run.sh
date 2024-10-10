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
        if command -v aria2c >/dev/null 2>&1; then
            aria2c -x 16 -s 16 -k 1M "${download_link}"
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
        if "${rocketmq_path}"/bin/tools.sh com.dyrnq.sca.Check ${className} >/dev/null 2>&1; then
            if [ "${fileName}" = "proxy" ]; then
                "${rocketmq_path}"/bin/tools.sh com.dyrnq.sca.Main ${className} $SCRIPT_DIR/$rocketmq_ver/"${fileName}".json json
            else
                "${rocketmq_path}"/bin/tools.sh com.dyrnq.sca.Main ${className} $SCRIPT_DIR/$rocketmq_ver/"${fileName}".conf conf
            fi
            "${rocketmq_path}"/bin/tools.sh com.dyrnq.sca.Main ${className} $SCRIPT_DIR/$rocketmq_ver/"${fileName}".md md
        else
            echo "${className} ${rocketmq_ver} ERROR"
        fi
        done


          
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