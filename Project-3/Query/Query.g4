grammar Query;

query 
    :    relation_name '<-' expr ';';

relation_name
    : Identifier;

Null
    : 'null'
    | 'Null'
    | 'NULL';
    
Identifier
    : Alpha (Alpha | Digit)*;
    
Varchar
    : '"' (~["])* '"'; // might not work

Alpha
    : [a-zA-Z_]+;
    
Integer
    : Digit (Digit)*;

Digit
    : [0-9]+;

expr
    : (atomic_expr
    | selection
    | projection
    | renaming
    | union
    | difference
    | product
    | natural_join);

atomic_expr
    : (relation_name
    | '(' expr ')');

selection
: 'select' '('condition')' atomic_expr;

condition
: conjunction ('||' conjunction)*;

conjunction
: comparison ('&&' comparison)*;


comparison
: (operand op operand
| '('condition')');

op
: ('=='
| '!='
| '<'
| '>'
| '<='
| '>=');

operand
: (Identifier
| literal);

attribute_name
: Identifier;

literal
: Null
| Integer
| Varchar;

projection
: 'project' '('attribute_list')' atomic_expr;

attribute_list
: attribute_name ( ',' attribute_name)*;

renaming
: 'rename' '('attribute_list')' atomic_expr;

union
: atomic_expr '+' atomic_expr;

difference
: atomic_expr '-' atomic_expr;

product
: atomic_expr '*' atomic_expr;

natural_join
: atomic_expr '&' atomic_expr;

command
: ( open_cmd
| close_cmd
| write_cmd
| exit_cmd
| show_cmd
| create_cmd
| update_cmd
| insert_cmd
| delete_cmd );

open_cmd
: 'OPEN' relation_name;

close_cmd
: 'CLOSE' relation_name;

write_cmd
: 'WRITE' relation_name;

exit_cmd
: 'EXIT';

show_cmd
: 'SHOW' atomic_expr;

create_cmd
: 'CREATE TABLE' relation_name '(' typed_attribute_list ')' 'PRIMARY KEY' '(' attribute_list')';

update_cmd
: 'UPDATE' relation_name 'SET' attribute_name '=' literal (',' attribute_name '=' literal)* 'WHERE' condition;

insert_cmd
: 'INSERT INTO' relation_name 'VALUES FROM' '('literal ( ',' literal)* ')'
| 'INSERT INTO' relation_name 'VALUES FROM RELATION' expr;
                                                            
delete_cmd
: 'DELETE FROM' relation_name 'WHERE' condition;

typed_attribute_list
: attribute_name type (',' attribute_name type)*;

type
: 'VARCHAR' '(' Integer')'
| 'INTEGER';

program
: (query
| command)*;

WS : [ \t\n\r]+ -> skip;
