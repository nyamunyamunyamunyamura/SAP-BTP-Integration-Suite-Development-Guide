# 🛠️ PRタイトル: [iFlow名 or Script名] の追加 / 修正

## 📌 目的・概要
<!-- 例: SFから受け取った従業員データの検証ロジック追加 -->

## ✅ チェックリスト（命名・スクリプトルール）

### 📁 Integration Flow関連
- [ ] Integration Flow名は `<SRC>_TO_<TGT>_<PURPOSE>` 形式
- [ ] ステップ名にプレフィックス番号付いている（例: `01_Receive`）

### 📜 Groovy Script関連
- [ ] スクリプトファイル名は `GS_<内容>.groovy`
- [ ] 変数/プロパティ名は CamelExpression
- [ ] コメントヘッダー（スクリプト説明・入力・出力）が記載されている
- [ ] `System.out.println` の使用はしていない（→ `MessageLog` を使用）

### ✅ 品質
- [ ] CodeNarcでLintチェックを実行し、エラーがない（作成中）
- [ ] 必要に応じてユニットテスト（Spockなど）を追加

---

## 🔍 補足・レビュー観点
<!-- 例: バリデーション条件の見直しが必要か確認してほしい -->
