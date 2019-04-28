const app = new Vue ({
    el: "#app",
    data: {
        titulo: 'App prueba',
        actividades:[],
        porAgregar: '',
        usuarios: [],
        cantidadResultados: 5 ,
        info: null
    },
    methods: {
        agregarActividad(){
            this.actividades.push({
                nombre: this.porAgregar,
                estado: false
            }),
            this.porAgregar = ''
        },
        editarActividad(index){
            this.actividades[index].estado = true;            
        },
        eliminarActividad(index){
            this.actividades.splice(index,1);
        },
        leerAPI() {
            axios.get('http://localhost:8081/actors', {
                params: {
                    'per_page': this.cantidadResultados
                }
            }).then(response => {console.log(response.data)
                this.usuarios = response.data.data
            }).catch(e => {
                console.log(e)
            })
        } 

    },

})

