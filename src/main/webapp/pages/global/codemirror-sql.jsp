<!doctype html>

<title>CodeMirror: SQL Mode for CodeMirror</title>
<meta charset="utf-8"/>

<link rel="stylesheet" href="../../resources/codemirror/lib/codemirror.css"/>
<link rel="stylesheet" href="../../resources/codemirror/theme/darcula.css"/>
<link rel="stylesheet" href="../../resources/codemirror/addon/hint/show-hint.css"/>
<script src="../../resources/codemirror/lib/codemirror.js"></script>
<script src="../../resources/codemirror/mode/sql/sql.js"></script>
<script src="../../resources/codemirror/addon/edit/matchbrackets.js"></script>
<script src="../../resources/codemirror/addon/hint/show-hint.js"></script>
<script src="../../resources/codemirror/addon/hint/sql-hint.js"></script>

<style>
    .CodeMirror {
        border-top: 1px solid black;
        border-bottom: 1px solid black;
    }
</style>

<article>

    <h2>SQL Mode for CodeMirror</h2>

    <form>

<textarea id="sql-code" name="sql-code">
-- SQL Mode for CodeMirror
SELECT SQL_NO_CACHE DISTINCT
		@var1 AS `val1`, @'val2', @global.'sql_mode',
		1.1 AS `float_val`, .14 AS `another_float`, 0.09e3 AS `int_with_esp`,
		0xFA5 AS `hex`, x'fa5' AS `hex2`, 0b101 AS `bin`, b'101' AS `bin2`,
		DATE '1994-01-01' AS `sql_date`, { T "1994-01-01" } AS `odbc_date`,
		'my string', _utf8'your string', N'her string',
        TRUE, FALSE, UNKNOWN
	FROM DUAL
	-- space needed after '--'
	# 1 line comment
	/* multiline
	comment! */
	LIMIT 1 OFFSET 0;
</textarea>

    </form>

    <script>
        window.onload = function () {
            window.editor = CodeMirror.fromTextArea(document.getElementById('sql-code'), {
                mode: "text/x-mariadb",
                theme: "darcula",
                indentWithTabs: true,
                smartIndent: true,
                lineNumbers: true,
                matchBrackets: true,
                autofocus: true,
                extraKeys: {"Ctrl-Space": "autocomplete"},
                hintOptions: {
                    tables: {
						employee: ["id", "first_name", "last_name","birth_day"],
						user: ["id", "username", "password"]
                    }
                }
            });
        };
    </script>

</article>
