-- CRIAÇÃO DE UMA VIEW PARA FILTRAR AS ÁREAS COM MAIOR DOAÇÃO
CREATE VIEW vw_area_mais_investida AS
SELECT 
    i.area_instituicao,
    SUM(CAST(d.valor_doacao AS DECIMAL)) AS total_doado
FROM 
    doacao d
JOIN 
    instituicao i ON d.instituicao_id = i.id_instituicao
GROUP BY 
    i.area_instituicao
ORDER BY 
    total_doado DESC;

SELECT * FROM VW_AREA_MAIS_INVESTIDA;


--FUNÇÃO ANTES DE EXECUTAR
CREATE OR REPLACE FUNCTION verificar_valor_doacao()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.valor_doacao::DECIMAL <= 0 THEN
        RAISE EXCEPTION 'O valor da doação deve ser maior que zero.';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- TRIGGER PARA ALERTAR QUANDO TENTAR FAZER UMA DOAÇÃO MENOR QUE ZERO/ VERIFICAR O VALOR
CREATE TRIGGER trg_verificar_valor_doacao
BEFORE INSERT OR UPDATE ON doacao
FOR EACH ROW
EXECUTE FUNCTION verificar_valor_doacao();

INSERT INTO doacao (data_doacao , valor_doacao, forma_pagamento_doacao, doador_id, instituicao_id)
VALUES ('2022-08-11', 286.00, 'Dinheiro', 9, 11);

--FILTRA DOAÇÕES ACIMA DE 500 REAIS
SELECT
    d.id_doacao,
    i.NOME_INSTITUICAO,
    d.VALOR_DOACAO
FROM
    doacao d
JOIN
    instituicao i ON d.instituicao_id = i.ID_INSTITUICAO
WHERE
    d.VALOR_DOACAO > 500;