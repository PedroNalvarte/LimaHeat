// archivo.js en el paquete "Js"
  function categoria () {
    
    window.location.href = "modulos.jsp";

}

function cargarCategorias() {
    fetch('modulosServlet')
        .then(response => response.json())
        .then(categorias => {
            var categoriasContainer = document.getElementById('categorias-container');

            categorias.forEach(categoria => {
                // Crear una tarjeta de categoría
                var card = document.createElement('div');
                card.className = 'card mb-3 categoria-card';

                // Crear un contenedor personalizado para la imagen
                var imageContainer = document.createElement('div');
                imageContainer.className = 'image-container';
                var cardImage = document.createElement('img');
                cardImage.className = 'card-img-top';
                cardImage.src = categoria.IMAGEN; // Supongamos que 'IMAGEN' es la URL de la imagen
                imageContainer.appendChild(cardImage);

                // Crear un contenedor personalizado para el contenido
                var contentContainer = document.createElement('div');
                contentContainer.className = 'card-body';

                // Agregar título
                var cardTitle = document.createElement('h5');
                cardTitle.className = 'card-title';
                cardTitle.textContent = categoria.NOMBRE_CATEGORIA;
                contentContainer.appendChild(cardTitle);


                // Agregar el contenedor de imagen y contenido a la tarjeta
                card.appendChild(imageContainer);
                card.appendChild(contentContainer);

                // Agregar la tarjeta al contenedor de categorías
                categoriasContainer.appendChild(card);
            });
        })
        .catch(error => {
            console.error('Error al cargar categorías:', error);
        });
}


// Llama a la función para cargar categorías cuando la página se cargue
document.addEventListener('DOMContentLoaded', cargarCategorias);
