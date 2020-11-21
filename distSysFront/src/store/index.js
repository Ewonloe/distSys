import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    users: [
      {id: 1, name: 'Nombre1 Apellido1', ranking: 4.5},
      {id: 2, name: 'Nombre2 Apellido2', ranking: 3.5},
      {id: 3, name: 'Nombre3 Apellido3', ranking: 4.0},
      {id: 4, name: 'Nombre4 Apellido4', ranking: 1.5},
      {id: 5, name: 'Nombre5 Apellido5', ranking: 2.0},
      {id: 6, name: 'Nombre6 Apellido6', ranking: 4.1},
      {id: 7, name: 'Nombre7 Apellido7', ranking: 3.2},
      {id: 8, name: 'Nombre8 Apellido9', ranking: 4.9},
      {id: 9, name: 'Nombre9 Apellido9', ranking: 1.2},
      {id: 10, name: 'Nombre10 Apellido10', ranking: 0.5},
      {id: 11, name: 'Nombre11 Apellido11', ranking: 2.8},
      {id: 12, name: 'Nombre12 Apellido12', ranking: 3.9}
    ],
    tasks:
    [
      {id: 1, nombre: 'tarea 1', descrip: 'Esta es la tarea 1', cant_vol_requeridos: 3, cant_vol_inscritos: 2, finicio: '08-10-2020', ffinal: '24-06-2021', id_emergencia:1, id_estado: 1},
      {id: 2, nombre: 'tarea 2', descrip: 'Esta es la tarea 2, distinta a la 1', cant_vol_requeridos: 5, cant_vol_inscritos: 5, finicio: '08-10-2020', ffinal: '24-06-2021', id_emergencia:1, id_estado: 0},
      {id: 3, nombre: 'tarea 3', descrip: 'Esta es la tarea 3, distinta a la 1 y 2', cant_vol_requeridos: 3, cant_vol_inscritos: 2, finicio: '08-10-2020', ffinal: '24-06-2021', id_emergencia:1, id_estado: 1},
      {id: 4, nombre: 'tarea 4', descrip: 'Esta es la tarea 4, distinta a la 1,2 y 3', cant_vol_requeridos: 5, cant_vol_inscritos: 5, finicio: '08-10-2020', ffinal: '24-06-2021', id_emergencia:1, id_estado: 0}
    ],
    emergencies:
    [
      {id: 1, nombre: 'emergencia 1', descrip: 'Esta es la emergencia 1', finicio: '08-10-2020', ffinal: '24-06-2021', id_institucion:1},
      {id: 2, nombre: 'emergencia 2', descrip: 'Esta es la emergencia 2, distinta a la 1', finicio: '08-10-2020', ffinal: '24-06-2021', id_institucion:2},
      {id: 3, nombre: 'emergencia 3', descrip: 'Esta es la emergencia 3, distinta a la 1 y 2', finicio: '08-10-2020', ffinal: '24-06-2021', id_institucion:3},
      {id: 4, nombre: 'emergencia 4', descrip: 'Esta es la emergencia 4, distinta a la 1,2 y 3', finicio: '08-10-2020', ffinal: '24-06-2021', id_institucion:2}
    ]
  },

  mutations: {
    
  },

  actions: {

  },

  modules: {
    
  }
})
