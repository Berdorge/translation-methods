parser grammar JavaParser;

options {
    tokenVocab = JavaLexer;
}

compilationUnit: packageDeclaration? (importDeclaration)* (typeDefinition)* EOF;

packageDeclaration: qualifiedName+ SEMICOLON;

importDeclaration: qualifiedName+ importWildcard? SEMICOLON;

importWildcard: DOT MUL;

typeDefinition: modifier* IDENTIFIER extendsDeclaration? implementsDeclaration? block;

extendsDeclaration: EXTENDS type;

implementsDeclaration: IMPLEMENTS typeList;

modifier: IDENTIFIER;

methodDefinition: modifier* type? IDENTIFIER parameters methodBody;

methodBody: block | SEMICOLON;

variablesDefinition: modifier* (type variableDefinitionList);

variableDefinitionList: variableDefinition (COMMA variableDefinition)*;

variableDefinition: IDENTIFIER (ASSIGN variableInitializer)?;

variableInitializer
    : arrayInitializer
    | expression
    ;

arrayInitializer: LBRACE (variableInitializer (COMMA variableInitializer)* COMMA?)? RBRACE;

parameters: LPAREN parameterList? RPAREN;

parameterList: parameter (COMMA parameter)*;

parameter: modifier* type variableDefinition;

qualifiedName: IDENTIFIER (DOT IDENTIFIER)*;

literal
    : NUMBER_LITERAL
    | CHAR_LITERAL
    | STRING_LITERAL
    | BOOL_LITERAL
    | NULL_LITERAL
    ;

block: LBRACE blockStatement* RBRACE;

blockStatement
    : variablesDefinition SEMICOLON
    | methodDefinition
    | typeDefinition
    | statement
    ;

statement
    : block # StatementBlock
    | IF parenthesisedExpression statement (ELSE statement)? # StatementIf
    | FOR LPAREN forConditions RPAREN statement # StatementFor
    | DO statement WHILE parenthesisedExpression SEMICOLON # StatementDo
    | TRY block (catchClause+ finallyBlock? | finallyBlock) # StatementTry
    | expression SEMICOLON # StatementExpression
    | IDENTIFIER expression? SEMICOLON # StatementExpressionOperator
    | SEMICOLON # StatementNop
    ;

catchClause: CATCH LPAREN modifier* catchType IDENTIFIER RPAREN block;

catchType: qualifiedName (OR qualifiedName)*;

finallyBlock: FINALLY block;

forConditions: forInit? SEMICOLON expression? SEMICOLON expressionList?;

forInit: variablesDefinition | expressionList;

parenthesisedExpression: LPAREN expression RPAREN;

expressionList: expression (COMMA expression)*;

methodCall: IDENTIFIER arguments;

arguments: LPAREN expressionList? RPAREN;

expression
    : (parenthesisedExpression | literal | IDENTIFIER) #PrimaryExpression
    | expression LBRACKET expression RBRACKET # SquareBracketExpression
    | expression DOT memberReference # MemberReferenceExpression
    | methodCall # MethodCallExpression
    | expression postfix = (INC | DEC) # PostfixOperatorExpression
    | prefix = (ADD | SUB | INC | DEC | TILDE | BANG) expression # UnaryOperatorExpression
    | LPAREN type RPAREN expression # CastExpression
    | NEW constructorInvocation # ObjectCreationExpression
    | expression bop = (MUL | DIV | MOD) expression # BinaryOperatorExpression
    | expression bop = (ADD | SUB) expression # BinaryOperatorExpression
    | expression shiftOperator expression # BinaryOperatorExpression
    | expression bop = (LE | GE | LANGLE | RANGLE) expression # BinaryOperatorExpression
    | expression bop = INSTANCEOF type # InstanceOfOperatorExpression
    | expression bop = (EQ | NEQ) expression # BinaryOperatorExpression
    | expression bop = AND expression # BinaryOperatorExpression
    | expression bop = XOR expression # BinaryOperatorExpression
    | expression bop = OR expression # BinaryOperatorExpression
    | expression bop = LOGICAL_AND expression # BinaryOperatorExpression
    | expression bop = LOGICAL_OR expression # BinaryOperatorExpression
    | <assoc = right> expression QUESTION expression COLON expression # TernaryExpression
    | <assoc = right> expression ASSIGN expression # AssignmentExpression
    ;

memberReference: IDENTIFIER | methodCall;

shiftOperator
    : LANGLE LANGLE
    | RANGLE RANGLE
    | RANGLE RANGLE RANGLE
    ;

constructorInvocation
    : qualifiedName classConstructorArguments
    | qualifiedName arrayConstructorArguments
    ;

arrayConstructorArguments
    : (LBRACKET RBRACKET)+ arrayInitializer
    | (LBRACKET expression RBRACKET)+ (LBRACKET RBRACKET)*
    ;

classConstructorArguments: arguments block?;

typeList: type (COMMA type)*;

type: qualifiedName (LBRACKET RBRACKET)*;
