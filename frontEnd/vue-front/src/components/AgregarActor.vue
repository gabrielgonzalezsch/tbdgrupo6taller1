<template>
    <div>
        <div class="container">
            <div class="card">
                <div class="card-body">
                    <div class="form-group">
                        <label for="input1">Nombre</label>
                        <input type="text" class="form-control" id="input1" placeholder="Ingrese nombre del actor" v-model="firstName">
                    </div>
                    <div class="form-group">
                        <label for="input2">Apellido</label>
                        <input type="text" class="form-control" id="input2" placeholder="Ingrese apellido del actor" v-model="lastName">
                    </div> 
                    <button @click.prevent="agregarActores()" class="btn btn-success btn-block">Agregar</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

import {mapState,mapActions} from 'vuex';

export default {
    name: 'AgregarActor',
    data() {
        return {
            firstName: '',
            lastName: '',
        }
    },
    computed: {
    },
    methods: {
        agregarActores() {
            this.$axios.post("/actors/new",{
                firstName: this.firstName,
                lastName: this.lastName,
            }).then((response) => {
                console.log(response.data);
                this.firstName = '';
                this.lastName = '';
            });
        },
    },
    created() {
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

