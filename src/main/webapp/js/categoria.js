function agregarCategoria() {
    window.location.href = "agregarCategoria.jsp";
}


document.addEventListener('DOMContentLoaded' ,cargarCategorias);
function cargarCategorias() {
    fetch('enviar_registro?accion=obtener')
            .then(response => response.json())
            .then(categorias => {
                var categoriasContainer = document.getElementById('categorias-container');

                categorias.forEach(categoria => {
                  
                    var card = document.createElement('div');
                    card.className = 'card mb-3 categoria-card';

                   
                    var contentContainer = document.createElement('div');
                    contentContainer.className = 'card-body';

                
                    var cardTitle = document.createElement('h5');
                    cardTitle.className = 'card-title';
                    cardTitle.textContent = categoria[1]; 
                    contentContainer.appendChild(cardTitle);
                    
                    var cardTitle = document.createElement('h6');
                    cardTitle.className = 'card-title';
                    cardTitle.textContent = categoria[0];
                    contentContainer.appendChild(cardTitle);

                    var editarButton = document.createElement('button');
                    editarButton.textContent = 'Editar';
                    editarButton.addEventListener('click', function () {
                        redirigirAEditarCategoria(categoria[0]); 
                    });

                   
                    contentContainer.appendChild(editarButton);

                    
                    card.appendChild(contentContainer);

                    
                    categoriasContainer.appendChild(card);
                });
            })
            .catch(error => {
                console.error('Error al cargar categorías:', error);
            });
}

function redirigirAEditarCategoria(idCategoria) {
    window.location.href = `agregarCategoria.jsp?id=${idCategoria}&accion=Editar`;
}
