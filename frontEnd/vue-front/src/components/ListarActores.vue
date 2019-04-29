<template>
    <div>
        <ul class="list-group list-group-flush">
            <li v-for="item of actores" :key="item.id"
            class="list-group-item">
                {{item.firstName}} {{item.lastName}}
            </li>
        </ul>
    </div>
</template>

<script>

import {mapState,mapActions} from 'vuex';

export default {
    name: 'AgregarActor',
    computed: {
        ...mapState(['actores']),
    },
    methods: {
        ...mapActions(['obtenerActores'])
    },
    created() {
        this.obtenerActores();
    }

}
</script>

