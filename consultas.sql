/*
 * Consulta 1: Listar equipos con sus detalles, incluyendo la liga y el país al que pertenecen
 * Ordenado por nombre de país, nombre de liga y nombre de equipo
 */
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


/*
 * Consulta 2: Listar ligas con el total de equipos registrados en cada una
 * Ordenado por el total de equipos de mayor a menor
 */
SELECT
    l.id,
    l.codigo,
    l.nombre,
    COUNT(e.id) AS total_equipos
FROM ligas l
         LEFT JOIN equipos e ON e.liga_id = l.id
GROUP BY l.id, l.codigo, l.nombre
ORDER BY total_equipos DESC;


/*
 * Consulta 3: Listar países con el total de ligas registradas en cada uno
 * Ordenado por el total de ligas de mayor a menor
 */
SELECT
    p.id,
    p.codigo,
    p.nombre,
    COUNT(l.id) AS total_ligas
FROM paises p
         LEFT JOIN ligas l ON l.pais_id = p.id
GROUP BY p.id, p.codigo, p.nombre
ORDER BY total_ligas DESC;


/*
 * Consulta 4: Obtener el país con la mayor cantidad de equipos registrados
 * Se limita el resultado a 1 registro
 */
SELECT
    p.nombre AS pais,
    COUNT(e.id) AS total_equipos
FROM paises p
         JOIN ligas l ON l.pais_id = p.id
         JOIN equipos e ON e.liga_id = l.id
GROUP BY p.nombre
ORDER BY total_equipos DESC
    LIMIT 1;


/*
 * Consulta 5: Listar ligas que no tienen equipos registrados
 * Utiliza un LEFT JOIN y filtra donde el ID del equipo es NULL
 */
SELECT
    l.id,
    l.codigo,
    l.nombre
FROM ligas l
         LEFT JOIN equipos e ON e.liga_id = l.id
WHERE e.id IS NULL;