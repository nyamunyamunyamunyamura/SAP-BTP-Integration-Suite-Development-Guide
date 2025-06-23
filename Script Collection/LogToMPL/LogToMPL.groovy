/**
 * スクリプト名: GS_LogToMPL.groovy
 * 説明: iFlowの処理開始時に任意のプロパティ値やヘッダー情報をMPLログに出力するテンプレート
 * 入力: プロパティ（例: myPropertyName）、ヘッダー（例: myHeaderName）
 * 出力: MPLログにINFOレベルでログメッセージを出力（sap.log.INFO）
 * 作成者: 社内開発者
 * 最終更新日: 2025-06-23
 */

// MPLへの情報出力テンプレート
import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;

def Message processData(Message message) {
    // ログレベルの指定 (ERROR, WARN, INFO, DEBUG, TRACE)
    def logLevel = "INFO";
    // ログに出力したいメッセージ
    def logMessage = "カスタムログメッセージ: iFlow処理開始";

    // メッセージプロパティの取得例
    def propertyValue = message.getProperty("myPropertyName");
    if (propertyValue != null) {
        logMessage += ", myPropertyName: " + propertyValue;
    }

    // ヘッダーの値の取得例
    def headerValue = message.getHeaders().get("myHeaderName");
    if (headerValue != null) {
        logMessage += ", myHeaderName: " + headerValue;
    }

    // ログ出力実行
    message.setProperty("sap.log." + logLevel, logMessage);

    return message;
}
