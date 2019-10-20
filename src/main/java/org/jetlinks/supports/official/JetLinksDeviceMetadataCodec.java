package org.jetlinks.supports.official;

import com.alibaba.fastjson.JSON;
import org.jetlinks.core.metadata.DeviceMetadata;
import org.jetlinks.core.metadata.DeviceMetadataCodec;
import reactor.core.publisher.Mono;

/**
 * <pre>
 *     {
 *          "id":"test",
 *          "name":"测试",
 *         "properties":[
 *              {
 *                  "id":"name",
 *                  "name":"名称",
 *                  "valueType":{
 *                      "type":"string"
 *                  }
 *              }
 *         ],
 *         "functions:"[
 *              {
 *                  "id":"playVoice",
 *                  "name":"播放声音",
 *                  "inputs":[
 *                      {
 *                         "id":"text",
 *                         "name":"文字内容",
 *                         "valueType":{
 *                           "type":"string"
 *                         }
 *                      }
 *                    ],
 *                    "output":{
 *                         "id":"success",
 *                         "name":"是否成功",
 *                         "valueType":{
 *                           "type":"boolean"
 *                         }
 *                    }
 *              }
 *         ],
 *         "events":[
 *              {
 *                  "id":"temp_sensor",
 *                  "name:"温度传感器",
 *                  "parameters":[
 *                      {
 *                          "id":"temperature",
 *                          "name":"温度",
 *                          "valueType":{
 *                            "type":"double"
 *                          }
 *                      },{
 *                            "id":"get_time",
 *                            "name":"采集时间",
 *                            "valueType":{
 *                              "type":"timestamp"
 *                            }
 *                        }
 *                  ]
 *              }
 *         ]
 *     }
 * </pre>
 *
 * @author zhouhao
 * @since 1.0.0
 */
public class JetLinksDeviceMetadataCodec implements DeviceMetadataCodec {
    @Override
    public Mono<DeviceMetadata> decode(String source) {
        return Mono.just(new JetLinksDeviceMetadata(JSON.parseObject(source)));
    }

    @Override
    public Mono<String> encode(DeviceMetadata metadata) {
        return Mono.just(new JetLinksDeviceMetadata(metadata).toJson().toJSONString());
    }
}
