/**
 * スクリプト名: AddQuotesToXmlText.groovy
 * 説明: 入力XMLの各フィールド値をダブルクォーテーションで囲み、整形済みXMLとして出力します。
 * 入力: <root><record>...</record></root> 形式のXML文字列
 * 出力: 各フィールドの値が "..." で囲まれたXML文字列
 * 作成者: sada.k@nttdata-gsl.co.jp
 * 最終更新日: 2025-05-25
 */

import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.XmlUtil
import groovy.xml.MarkupBuilder
import groovy.util.XmlSlurper
import java.io.StringWriter

Message processData(Message message) {
  // 入力データ（XML）を文字列として取得
  def body = message.getBody(String) as String

  // XML文字列を構造化データとして読み込む
  def xml = new XmlSlurper().parseText(body)

  // XML出力用のWriterおよびBuilderを準備
  StringWriter writer = new StringWriter()
  MarkupBuilder builder = new MarkupBuilder(writer)

  // 出力用XMLのルート要素 <root> を生成
  builder.root {
    // 各 <record> 要素に対して処理を実施
    xml.record.each { data ->
      record {
        // <record> 配下の各フィールド要素に対して値を "..." で囲んで出力
        data.children().each { field ->
          "${field.name()}"("\"${field.text()}\"")
        }
      }
    }
  }

  // 整形済みXML文字列をボディに設定し、戻り値として返却
  message.setBody(XmlUtil.serialize(writer.toString()))
  return message
}
