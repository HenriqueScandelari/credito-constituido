DELETE FROM credito;
INSERT INTO credito (numero_credito, numero_nfse, data_constituicao, valor_issqn, tipo_credito, simples_nacional, aliquota, valor_faturado, valor_deducao, base_calculo)
VALUES
    ('123456', '7891011', '2024-02-25', 1500.75, 'ISSQN', true, 5.0, 30000.00, 5000.00, 25000.00),
    ('789012', '7891011', '2024-02-26', 1200.50, 'ISSQN', false, 4.5, 25000.00, 4000.00, 21000.00),
    ('654321', '1122334', '2024-01-15', 800.50, 'Outros', true, 3.5, 20000.00, 3000.00, 17000.00);

-- INSERT INTO public.users (id, login, password, role)
-- VALUES ('e8e5b117-de52-42a0-9e03-945477c9b7b1', 'admin', '$2a$10$sxaSpuYgX68ek7QZg9sBfuEpE3H.u4f2jza2zUSMp/69PlkSJs6QS', '0');
