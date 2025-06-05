# SAP CPI Groovyスクリプト - XMLフィールド値のダブルクォート付与

このGroovyスクリプトは、SAP Cloud Integration（SAP CPI）において、受信したXMLデータの各要素の値を**ダブルクォーテーション（"`"）で囲って出力する**処理を行います。

---

## 🎯 目的

- XMLの各レコードに含まれるフィールドのテキスト値を `"..."` で囲んで変換
- CPIフローの中間処理として、後続システムが期待する形式に整形

---

## 🛠 処理概要

1. `XmlSlurper` で入力XMLをパース
2. 各 `<record>` 要素をループ処理
3. 子要素の値をダブルクォート付きで出力
4. `MarkupBuilder` により整形済みのXMLを構築
5. `XmlUtil.serialize()` で整形済みXMLを出力として設定

---

## 📥 入力・出力例

```xml
<root>
  <record>
    <Place>東京</Place>
    <DeliveryTime>2025-06-30</DeliveryTime>
  </record>
</root>

<root>
  <record>
    <Place>"東京"</Place>
    <DeliveryTime>"2025-06-30"</DeliveryTime>
  </record>
</root>

---
