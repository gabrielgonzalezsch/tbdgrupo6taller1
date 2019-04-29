<template>
    <div>
        <div class="container">
            <div class="card">
                <div class="card-body">
                    <form>
                        <div class="form-group">
                            <label for="input1">Nombre</label>
                            <input type="text" class="form-control" id="input1" placeholder="Ingrese nombre del actor">
                        </div>
                        <div class="form-group">
                            <label for="input2">Apellido</label>
                            <input type="text" class="form-control" id="input2" placeholder="Ingrese apellido del actor">
                        </div> 
                        <button type="submit" class="btn btn-success btn-block">Agregar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

import {mapState,mapActions} from 'vuex';

export default {
    name: 'AgregarActor',
    computed: {
        ...mapState(['actores','firstName','lastName']),
    },
    methods: {
        ...mapActions(['obtenerActores'])
    },
    created() {
        this.obtenerActores();
    }

}
</script>

<style>
    .card {
        padding: 1%;
    }

    .form {
        display: block;
    }
</style>

