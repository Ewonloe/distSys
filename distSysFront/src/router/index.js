import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Dashboard',
    component: () => import(/* webpackChunkName: "about" */ '../views/Dashboard.vue')
  },
  {
    path: '/emergencies',
    name: 'Emergencies',
    component: () => import('../views/Emergencies.vue')
  },
  {
    path: '/permitRequest',
    name: 'Permits',
    component: () => import('../views/Permits.vue')
  },
  {
    path: '/FindVoluntarie',
    name: 'FindVoluntarie',
    component: () => import('../views/FindVoluntarie.vue')
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
