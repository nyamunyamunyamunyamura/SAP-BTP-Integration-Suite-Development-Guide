/**
 * スクリプト名: GS_ConvertUtf8ToShiftJis.groovy
 * 説明: メッセージの文字コードがShift_JISでない場合にUTF-8からShift_JISへ変換し、Bodyおよびプロパティを更新する。
 * 入力: UTF-8エンコードされたバイナリデータ、およびCamelCharsetNameプロパティ（省略可）
 * 出力: Shift_JISに変換されたバイナリデータ、プロパティにCamelCharsetName=Shift_JISを設定
 * 作成者: GSL佐田
 * 最終更新日: 2025-06-23
 */

import com.sap.gateway.ip.core.customdev.util.Message;
import java.nio.charset.StandardCharsets;

def Message processData(Message message) {
    // Properties取得
    def properties = message.getProperties()
    def charsetName = properties.get("CamelCharsetName")

    // UTF_8からShift_JISに変換
    if(charsetName == null || !charsetName.equalsIgnoreCase("Shift_JIS")) {
        def bodyBytes = message.getBody(byte[])
        def shiftJisString = new String(bodyBytes, StandardCharsets.UTF_8).getBytes("Shift_JIS")

        // Shift_JISに変換されたデータをBodyに設定
        message.setBody(shiftJisString)
        // CamelCharsetNameをPropertyに設定
        message.setProperty("CamelCharsetName", "Shift_JIS")
    }

    return message;
}
