import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Dashboard from "../components/Dashboard";
import CoopTerm from "../components/CoopTerms";
import Events from "../components/Events";


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/employer',
      name: 'Dashboard',
      meta: { layout: "default" },
      component: Dashboard
    },
    {
      path: '/coop-term',
      name: 'Coopterm',
      meta: { layout: "default" },
      component: CoopTerm
    },
    {
      path: '/events',
      name: 'Events',
      meta: { layout: "default" },
      component: Events
    }
  ]
})
