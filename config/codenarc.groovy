ruleset {
    description 'SAP Cloud Integration Groovy Ruleset'

    // 命名規則
    MethodName {
        regex = /^[a-z][a-zA-Z0-9]*$/
        violationMessage = 'メソッド名はcamelCase形式にしてください。'
    }

    VariableName {
        regex = /^[a-z][a-zA-Z0-9]*$/
        violationMessage = '変数名はcamelCase形式にしてください。'
    }

    ClassName {
        regex = /^[A-Z][a-zA-Z0-9]*$/
        violationMessage = 'クラス名はパスカルケースにしてください。'
    }

    // 使用禁止API
    IllegalRegexRule(name: 'DisallowPrintln') {
        regex = /System\.out\.println/
        message = 'System.out.printlnは使用禁止です（ログAPIを使ってください）'
    }

    // 複雑性
    CyclomaticComplexity {
        maxComplexity = 10
    }

    // 無駄なコード
    UnusedImport(enabled: true)
    UnusedVariable(enabled: true)
}
