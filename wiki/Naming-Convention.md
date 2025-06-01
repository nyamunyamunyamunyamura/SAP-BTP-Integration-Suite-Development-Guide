# 命名規則ガイドライン
SAP BTP Integration Suite（旧SAP CPI）のCloud Integrationでの開発ルールを策定するのは、保守性・再利用性・可読性・運用性の観点から非常に重要です。

# 📦 パッケージ命名規則（Integration Package）

## 推奨ルール

### 命名パターン

### 例

- `com.company.sap.s4hana.masterdata`  
- `com.company.sf.employee.sync`  
- `com.company.edi.order.processing`  

## 命名方針

- **再利用可能なスコープ**（単一の連携用途に閉じないもの）は**分離して管理**する。  
- **テナント内で一意**かつ、**可読性のある構造**にすること。


## Integration Flow名
- パターン: `<SOURCE>_TO_<TARGET>_<PURPOSE>`
- 例: `SF_TO_S4HANA_EMPLOYEE_CREATE`
