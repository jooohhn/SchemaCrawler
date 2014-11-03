SELECT /*+ PARALLEL(AUTO) */
  NULL AS ROUTINE_CATALOG,
  OWNER AS ROUTINE_SCHEMA,
  OBJECT_NAME AS ROUTINE_NAME,
  OBJECT_NAME AS SPECIFIC_NAME,
  'SQL' AS ROUTINE_BODY,
  DBMS_METADATA.GET_DDL(OBJECT_TYPE,OBJECT_NAME,OWNER) AS ROUTINE_DEFINITION
FROM
  ALL_PROCEDURES
WHERE
  UPPER(OBJECT_TYPE) IN ('FUNCTION', 'PROCEDURE')
  AND OWNER NOT IN ('CTXSYS', 'DBSNMP', 'DMSYS', 'MDDATA', 'MDSYS', 'OLAPSYS', 'ORDPLUGINS', 'ORDSYS', 'OUTLN', 'SI_INFORMTN_SCHEMA', 'SYS', 'SYSMAN', 'SYSTEM', 'XDB')
  AND OWNER NOT LIKE 'APEX%'
  AND AUTHID = 'CURRENT_USER'
ORDER BY
  ROUTINE_SCHEMA,
  ROUTINE_NAME