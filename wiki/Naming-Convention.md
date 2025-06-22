# 命名規則ガイドライン
SAP BTP Integration Suite（旧SAP CPI）のCloud Integrationでの開発ルールを策定するのは、保守性・再利用性・可読性・運用性の観点から非常に重要です。

# 📦 パッケージ命名規則（Integration Package）

### 例

- `com.company.sap.s4hana.masterdata`  
- `com.company.sf.employee.sync`  
- `com.company.edi.order.processing`  

## 命名方針

- **再利用可能なスコープ**（単一の連携用途に閉じないもの）は**分離して管理**する。  
- **テナント内で一意**かつ、**可読性のある構造**にすること。


# 🧩 ステップ名命名規則（Integration Flow内のステップ）
### 例

- `01_Receive_From_SF`  
- `02_Transform_Employee_JSON_To_XML`  
- `03_Call_S4HANA_API`  
- `04_Handle_Response`
- ![](https://github.com/nyamunyamunyamunyamura/SAP-BTP-Integration-Suite-Development-Guide/blob/99b96288c17536afb73988aff12ab0a1c45231ee/resouce/Numb_Step.png)

## 命名方針

- ステップ順に**通し番号（例: 01, 02, 03）**を振ることで、**処理の流れを可視化**し、**可読性を向上**させる。
- **技術ステップ**（例: Content Modifier, Script など）は、**処理の意図を簡潔に表現**する名前にする。


# 💻 Groovy Scriptファイル名命名規則
### 例

- `GS_TransformEmployeeData.groovy`  
- `GS_ValidatePayload.groovy`  
- `GS_GenerateUUID.groovy`
-  ![resouce/NamingRule_GS.png](https://github.com/nyamunyamunyamunyamura/SAP-BTP-Integration-Suite-Development-Guide/blob/f440a93327b26e4aa0d31a28ca46c88ce0805ed5/resouce/NamingRule_GS.png)

## 命名方針

- ファイル名の先頭に必ず **`GS_` プレフィックス**を付けて、**Script Type を明示**する。  
- スクリプトの役割を明確に表す名前にします。
- **パスカルケース (CamelCase)** を使用し、スペースや特殊文字は使用しません。
  - 例: `SetHeaderAndProperty.groovy`, `JsonPayloadParser.groovy`, `ApiErrorResponseHandler.groovy`
- **複数の用途が混在しているスクリプト**は、**できるだけ小分けに**してシンプルに保つ
- `IF名_番号_処理名_バージョン`　などでも可

# Groovy Script記述規則
## コメント
以下のフォーマットでスクリプト先頭に以下のような情報を記載し、他の人がプログラムを見た時分かりやすくする。
```groovy:CommentRule.groovy
/**
 * スクリプト名: ${スクリプト名}.groovy
 * 説明: ${スクリプトの端的な説明}
 * 入力: ${想定データの構造について記載}
 * 出力: ${出力されるデータについて記載}
 * 作成者: ${作成者の名前}
 * 最終更新日: ${YYYY-MM-DD}
 */
```
### 例
- [AddQuote.groovy](https://github.com/nyamunyamunyamunyamura/SAP-BTP-Integration-Suite-Development-Guide/blob/1e67fd4a5dacdfdcf424e5f85d590e5438f31dc2/Script%20Collection/AddQuotesToXmlText/AddQuotesToXmlText.groovy)

## 変数名
- キャメルケース (camelCase) を使用します。
- 変数の目的や内容がわかる名前にします。
  - 例: `messageBody`, `extractedId`, `httpStatusCode`, `retryCount`
## 関数名 (メソッド名):
- キャメルケース (camelCase) を使用します。
- 関数が実行するアクションを表す動詞から始めます。
    - 例: `processData`, `extractFieldValue`, `handleApiError`
## 定数名
- 全て大文字 (ALL_CAPS) を使用し、単語間はアンダースコア (_) で繋ぎます。
   - 例: `MAX_RETRIES`, `DEFAULT_TIMEOUT`
## iFlowのプロパティ名:
- スクリプト内でアクセスするiFlowのプロパティ名も、一貫性を持たせることが望ましいです。
-  キャメルケース (camelCase) または パスカルケース (CamelCase) を推奨します。
-  リソースの種別を明確にするために、`PR_`/`HD_`プレフィックスを付ける事も有効。
  - 例  : `documentType`, `customerID`, `processStatus`
