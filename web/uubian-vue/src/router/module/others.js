/**
 * Created by Vinsea on 2017/6/7.
 */
const countDown = r => require.ensure([], () => r(require('../../views/others/CountDown.vue')), 'countDown')

export default
[
  {
    path: '/countDown',
    name: 'countDown',
    component: countDown
  }
]
