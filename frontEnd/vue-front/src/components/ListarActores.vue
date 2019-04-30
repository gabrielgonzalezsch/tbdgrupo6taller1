<template>
    <div class="card">
        <div class="card-body scrollable">
            <ul class="list-group list-group-flush">
                <li v-for="(item,index) of actores" :key="item.id"
                class="list-group-item">
                    {{item.firstName}} {{item.lastName}}
                    <button type="button" class="btn btn-primary" data-toggle="modal" :data-target="'#actor-'+index">
                    Mostrar Peliculas
                    </button>
                    <div class="modal fade" :id="'actor-'+index" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Peliculas</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <li v-for="pelicula of item.peliculas" :key="pelicula.id"
                            class="list-group-item">
                                {{ pelicula.title }}
                            </li>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Save changes</button>
                        </div>
                        </div>
                    </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</template>

<script>

import {mapState,mapActions} from 'vuex';

export default {
    name: 'AgregarActor',
    data() {
        return {
            actores: [],
        }
    },
    computed: {
    },
    methods: {
        //...mapActions(['obtenerActores']),
        obtenerActores() {
            this.$axios.get("/actors").then((response) => {
                this.actores = response.data.reverse(); 
            });
        },
    },
    created() {
        this.obtenerActores();
    }

}
</script>

<style lang="css">
    .scrollable {
        height: 60vh;
        overflow-y: scroll;
    }
</style>