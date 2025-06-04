# 命名規則ガイドライン
SAP BTP Integration Suite（旧SAP CPI）のCloud Integrationでの開発ルールを策定するのは、保守性・再利用性・可読性・運用性の観点から非常に重要です。

# 📦 パッケージ命名規則（Integration Package）

## 推奨ルール

### 例

- `com.company.sap.s4hana.masterdata`  
- `com.company.sf.employee.sync`  
- `com.company.edi.order.processing`  

## 命名方針

- **再利用可能なスコープ**（単一の連携用途に閉じないもの）は**分離して管理**する。  
- **テナント内で一意**かつ、**可読性のある構造**にすること。


# 🧩 ステップ名命名規則（Integration Flow内のステップ）

## 推奨ルール

### 例

- `01_Receive_From_SF`  
- `02_Transform_Employee_JSON_To_XML`  
- `03_Call_S4HANA_API`  
- `04_Handle_Response`  

## 命名方針

- ステップ順に**通し番号（例: 01, 02, 03）**を振ることで、**処理の流れを可視化**し、**可読性を向上**させる。
- **技術ステップ**（例: Content Modifier, Script など）は、**処理の意図を簡潔に表現**する名前にする。


# 💻 Groovy Scriptファイル名命名規則

## 推奨ルール

### 例

- `GS_TransformEmployeeData.groovy`  
- `GS_ValidatePayload.groovy`  
- `GS_GenerateUUID.groovy`
- - resouce/NamingRule_GS.png

## 命名方針

- ファイル名の先頭に必ず **`GS_` プレフィックス**を付けて、**Script Type を明示**する。  
- **ファイル名のみで処理内容が分かるように**命名すること。  
- **複数の用途が混在しているスクリプト**は、**できるだけ小分けに**してシンプルに保つ
