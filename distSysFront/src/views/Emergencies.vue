<template>
    <div>
        <b-button type="button" v-on:click="Redirigir('/emergencies/create')" style="float:right" >Crear Emergencia</b-button>
        <b-row>
            <b-col v-for="emergencie in emergencies" :key="emergencie.id"
                class="mb-3" cols="12" md="6" lg="4" >
                <b-card no-body style="max-width: 20rem;" img-src="https://www.lavanguardia.com/r/GODO/LV/p3/WebSite/2016/08/24/Recortada/20160824-636076302508840102_20160824101318-kxKF-U404161263814nO-992x558@LaVanguardia-Web.jpg" img-alt="Image" img-top>
                    <b-card-body>
                        <b-card-title>{{emergencie.nombre}}</b-card-title>
                        <b-card-sub-title class="mb-2">Descripcion</b-card-sub-title>
                        <b-card-text>{{emergencie.descrip}}</b-card-text>
                    </b-card-body>

                    <b-list-group flush>
                        <b-list-group-item class="d-flex justify-content-between align-items-center">
                            Fecha de inicio: {{emergencie.finicio}}
                        </b-list-group-item>
                        <b-list-group-item class="d-flex justify-content-between align-items-center">
                            Fecha de termino: {{emergencie.ffin}}
                        </b-list-group-item>
                        <b-list-group-item class="d-flex justify-content-between align-items-center" v-on:click="showModal(emergencie.id_institucion)">
                            Institucion click aqui => 
                            
                                
                            <b-iconstack font-scale="2">
                                <b-icon stacked icon="circle-fill" variant="success"></b-icon>
                                <b-icon stacked icon="building" scale="0.5" variant="white"></b-icon>
                                <b-icon stacked icon="circle" variant="warning"></b-icon>
                            </b-iconstack>
                        </b-list-group-item>
                        <b-card-body>
                            <a :href="`/emergencies/abilities/${emergencie.id}/${emergencie.id_institucion}`" class="card-link" > Editar habilidades</a>
                            
                            <a :href="`/emergencies/Task/${emergencie.id}`" class="card-link" > Ver tareas</a>
                        </b-card-body>
                    </b-list-group>
                </b-card>
            </b-col>     
        </b-row>
        <b-modal ref="my-modal" hide-footer title="Institución">
            <h3 align="center">{{institucion}}</h3>
            <!--
            <img  width="460"
            height="350" src="https://thumbs.gfycat.com/PlumpExemplaryCoral-size_restricted.gif" class="center">
            -->
            <img  width="460"
            height="350" src="https://www.definicionabc.com/wp-content/uploads/Instituciones.jpg" class="center">
        <div class="d-block text-center" >
            
        </div>
        <b-button class="mt-3" variant="outline-danger" block @click="hideModal">Close Me</b-button>
        </b-modal>


        
    </div>
</template>

<script>
    import axios from "axios";
    export default {
        name: 'Tasks',
        data(){
            return{
                emergencies:null,
                muestras:null,
                institucion:null,
                counter:-1
            }
        },
        methods:{
            async getEmergencies(){
                 let datos = await axios.get('http://localhost:8080/emergencias/all')
                 this.emergencies=await datos.data
            },
            Redirigir(page){
                window.location.href = page
            },
            RedirigirHabilidad(){
                window.location.href='/emergencies/abilities/'+emergencie.id+'/'+emergencie.id_institucion
            },
            getemergenciesAndInstitucions(){
                 axios.get('http://localhost:8080/emergencias/all')
                    .then(response => {
                        this.emergencies = response.data
                        for (var i=0; i<this.emergencies.length; i++)
                        {
                            axios.get('http://localhost:8080/instituciones/'+ this.emergencies[i].id_institucion)
                            .then(response=> {
                                this.instituciones.push(response.data.nombre)
                            })
                        }
                    })
                    .catch(error => {

                        console.log(error)

                    })                 
            },
            mostrarInstitucion(id)
            {
                axios.get('http://localhost:8080/instituciones/'+id)
                .then(response => {this.institucion=response.data.nombre})
            },
            showModal(id) {
                this.mostrarInstitucion(id)
                this.$refs['my-modal'].show()
            },
            hideModal() {
                this.$refs['my-modal'].hide()
            }            
        },
        created(){
            this.getEmergencies()
        }

    }
</script>
