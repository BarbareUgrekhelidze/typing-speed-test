import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  base: '/',
  plugins: [react()],
  resolve: {
    dedupe: ['react', 'react-dom', 'react-router-dom'],
  },
  server: {
    proxy: {
      '/easy': {
        target: 'http://localhost:8080',
        changeOrigin: true,
      },
    },
  },
})