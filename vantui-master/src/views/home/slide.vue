<template>
  <transition name="slide">
    <slot>

    </slot>
  </transition>
</template>

<script>
export default {
  name: "slide"
}
</script>

<style scoped>
.slide-enter {
  right: 100%;
}

.slide-enter-active {
  transition: right 500ms linear;
}

.slide-enter-to {
  right: 0;
}

.slide-leave {
  left: 0;
}

.slide-leave-active {
  transition: left 500ms linear;
}

.slide-leave-to {
  left: 100%;
}
</style>