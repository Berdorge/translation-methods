lexer grammar JavaLexer;

EXTENDS      : 'extends';
IMPLEMENTS   : 'implements';

IF           : 'if';
ELSE         : 'else';
WHILE        : 'while';
FOR          : 'for';
DO           : 'do';

TRY          : 'try';
CATCH        : 'catch';
FINALLY      : 'finally';

INSTANCEOF   : 'instanceof';
NEW          : 'new';

NUMBER_LITERAL: (Digits ('.' Digits?)? | '.' Digits) [fFdDlL]?;

BOOL_LITERAL: 'true' | 'false';

CHAR_LITERAL: '\'' (~['\\\r\n] | EscapedChar) '\'';

STRING_LITERAL: '"' (~["\\\r\n] | EscapedChar)* '"';

NULL_LITERAL: 'null';

LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
LBRACKET: '[';
RBRACKET: ']';
SEMICOLON: ';';
COMMA: ',';
DOT: '.';

ASSIGN: '=';
LANGLE: '<';
RANGLE: '>';
BANG: '!';
TILDE: '~';
QUESTION: '?';
COLON: ':';
EQ: '==';
LE: '<=';
GE: '>=';
NEQ: '!=';
LOGICAL_AND: '&&';
LOGICAL_OR: '||';
INC: '++';
DEC: '--';
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
AND: '&';
OR: '|';
XOR: '^';
MOD: '%';

IDENTIFIER: Alpha AlphaNum*;

fragment EscapedChar: '\\' [btnfr"'\\];

fragment Digits: [0-9] ([0-9_]* [0-9])?;

fragment AlphaNum: Alpha | [0-9];

fragment Alpha: [a-zA-Z$_];

WHITESPACE: [ \t\r\n\u000C]+ -> channel(HIDDEN);
BLOCK_COMMENT: '/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT: '//' ~[\r\n]* -> channel(HIDDEN);
