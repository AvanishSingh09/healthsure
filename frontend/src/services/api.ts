import axios from 'axios';

const api = axios.create({
  baseURL: import.meta.env.VITE_API_URL || 'https://healthsure-healthcare.onrender.com/api',
  headers: {
    'Content-Type': 'application/json',
  },
});

// Request interceptor for attaching JWT token
api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('healthsure_token');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => Promise.reject(error)
);

// Response interceptor for handling 401 unauthenticated globally
api.interceptors.response.use(
  (response) => response,
  (error) => {
    if (error.response && error.response.status === 401) {
      const isAuthPath = window.location.pathname.startsWith('/login') || window.location.pathname.startsWith('/register');
      if (!isAuthPath) {
        localStorage.removeItem('healthsure_token');
        localStorage.removeItem('healthsure_user');
        window.location.href = '/login';
      }
    }
    return Promise.reject(error);
  }
);

export default api;
