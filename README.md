# api-comidita

23/05/23 Subiendo primera version funcionando.

### Endpoints
- /ingrediente - Recibe JSON con "nombre" y "descripcion" y almacena en DB
- /ingrediente/etiquetar - Recibe JSON con "idIngrediente" y "listaEtiquetas" y actualiza en DB
- /etiqueta - Recibe JSON con "nombre" y almacena en DB
- /receta - Recibe JSON con "nombre", "descripcion", "instrucciones", "listaIngredientes" y almacena en DB
- /receta/etiquetar - Recibe JSON con "idReceta" y "listaEtiquetas" y actualiza en DB

### Roadmap
- Refactor de las tablas de la DB para incluir cantidades y unidades de medida para distintos ingredientes. 
- Endpoint para filtrado de recetas por etiquetas. 
- Repensar jerarquía de etiquetas. *(quizas re pensar toda la cuestion con las etiquetas)* 
- Endpoint para busqueda de recetas posibles a partir de n ingredientes.
