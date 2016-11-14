CREATE OR REPLACE PROCEDURE USUCCHATA.pa_alumno_generar_codigo(p_codigo_generado out varchar2) IS

v_codigo varchar2(10);
v_valor  numeric(7);

begin 

   SELECT MAX(CODIGOALUMNO_PK) INTO v_codigo FROM alumno;
   
if v_codigo is null then 
   begin
        v_valor:=1;                        
    end;
else
    begin                    
         SELECT  TO_NUMBER(SUBSTR(v_codigo,4,7),'9999999')+1 INTO v_valor FROM DUAL;                 
    end;
end if;


if v_valor<1000000 then
   begin
       dbms_output.put_line('No desbordado');
       v_codigo:=(CASE 
                      WHEN v_valor<10 THEN CONCAT('000000',TO_CHAR(v_valor))
                      WHEN v_valor<100 THEN CONCAT('00000',TO_CHAR(v_valor))
                      WHEN v_valor<1000 THEN CONCAT('0000',TO_CHAR(v_valor))
                      WHEN v_valor<10000 THEN CONCAT('000',TO_CHAR(v_valor))
                      WHEN v_valor<100000 THEN CONCAT('00',TO_CHAR(v_valor))
                      WHEN v_valor<1000000 THEN CONCAT('0',TO_CHAR(v_valor))
                      ELSE TO_CHAR(v_valor) END);
                      
                     p_codigo_generado:= v_codigo;
   end;
else 
   begin
       dbms_output.put_line('Codigo de alumno desbordado.');
   end; 
end if;     

    
    exception 
    when no_data_found then
    dbms_output.put_line('no_data_found');

    when zero_divide then
    dbms_output.put_line('zero_divide');

    when others then
    dbms_output.put_line('others');
end;

-------EXE--------------

declare
 p_codigo_generado varchar2(10);
 
begin
     pa_alumno_generar_codigo(p_codigo_generado);
     
     DBMS_OUTPUT.PUT_LINE('p_codigo_generado: ' || p_codigo_generado);
end;
----------------------