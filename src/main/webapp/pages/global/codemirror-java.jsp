<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CodeMirror: Java Mode for CodeMirror</title>
    <link rel="stylesheet" href="../../resources/codemirror/lib/codemirror.css"/>
    <link rel="stylesheet" href="../../resources/codemirror/theme/darcula.css"/>
    <link rel="stylesheet" href="../../resources/codemirror/addon/hint/show-hint.css"/>
    <script src="../../resources/codemirror/lib/codemirror.js"></script>
    <script src="../../resources/codemirror/mode/clike/clike.js"></script>
    <script src="../../resources/codemirror/addon/edit/matchbrackets.js"></script>
    <script src="../../resources/codemirror/addon/hint/show-hint.js"></script>

    <style>
        .CodeMirror {
            border: 2px inset #dee;
        }
    </style>

</head>
<body>

<article>
    <h2>Java Mode for CodeMirror</h2>
    <form>
        <div><textarea id="java-code" name="java-code">
import com.demo.util.MyType;
import com.demo.util.MyInterface;

public enum Enum {
  VAL1, VAL2, VAL3
}

public class Class<T, V> implements MyInterface {
  public static final MyType<T, V> member;

  private class InnerClass {
    public int zero() {
      return 0;
    }
  }

  @Override
  public MyType method() {
    return member;
  }

  public void method2(MyType<T, V> value) {
    method();
    value.method3();
    member = value;
  }
}
</textarea></div>
    </form>

    <script>
        window.onload = function () {
            window.editor = CodeMirror.fromTextArea(document.getElementById('java-code'), {
                mode: "text/x-java",
                theme: "darcula",
                indentWithTabs: true,
                smartIndent: true,
                lineNumbers: true,
                matchBrackets: true,
                autofocus: true,
                extraKeys: {"Ctrl-Space": "autocomplete"},
                hintOptions: {
                    tables: {
                        users: ["name", "score", "birthDate"],
                        countries: ["name", "population", "size"]
                    }
                }
            });
        };
    </script>

</article>

</body>
</html>