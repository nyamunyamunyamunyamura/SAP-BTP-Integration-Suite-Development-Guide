import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.XmlUtil
import groovy.xml.MarkupBuilder
import groovy.util.XmlSlurper
import java.io.StringWriter

Message processData(Message message) {
  // 入力データを取得
  def body = message.getBody(String) as String
  def xml = new XmlSlurper().parseText(body)

  // XML出力用にStringWriterとMarkupBuilderを生成
  StringWriter writer = new StringWriter()
  MarkupBuilder builder = new MarkupBuilder(writer)

  // XML構造を出力する
  builder.root {
    xml.record.each { data ->
      record {
        data.children().each { field ->
          "${field.name()}"("\"${field.text()}\"")
        }
      }
    }
  }

  message.setBody(XmlUtil.serialize(writer.toString()))
  return message
}
