SELECT
    e.id            AS equipo_id,
    e.codigo        AS codigo_equipo,
    e.nombre        AS nombre_equipo,
    l.codigo        AS codigo_liga,
    l.nombre        AS nombre_liga,
    p.codigo        AS codigo_pais,
    p.nombre        AS nombre_pais
FROM equipos e
         JOIN ligas l ON e.liga_id = l.id
         JOIN paises p ON l.pais_id = p.id
ORDER BY p.nombre, l.nombre, e.nombre;


SELECT
    l.id,
    l.codigo,
    l.nombre,
    COUNT(e.id) AS total_equipos
FROM ligas l
         LEFT JOIN equipos e ON e.liga_id = l.id
GROUP BY l.id, l.codigo, l.nombre
ORDER BY total_equipos DESC;

SELECT
    p.id,
    p.codigo,
    p.nombre,
    COUNT(l.id) AS total_ligas
FROM paises p
         LEFT JOIN ligas l ON l.pais_id = p.id
GROUP BY p.id, p.codigo, p.nombre
ORDER BY total_ligas DESC;

SELECT
    p.nombre AS pais,
    COUNT(e.id) AS total_equipos
FROM paises p
         JOIN ligas l ON l.pais_id = p.id
         JOIN equipos e ON e.liga_id = l.id
GROUP BY p.nombre
ORDER BY total_equipos DESC
    LIMIT 1;

SELECT
    l.id,
    l.codigo,
    l.nombre
FROM ligas l
         LEFT JOIN equipos e ON e.liga_id = l.id
WHERE e.id IS NULL;