const app = new Vue ({
    el: "#app",
    data: {
        titulo: 'App',
        actividades:[],
        porAgregar: ''
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
        }

    }
})