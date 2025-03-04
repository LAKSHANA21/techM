// Initialize AOS with enhanced settings
AOS.init({
    duration: 800,
    easing: 'ease-in-out',
    once: false,
    mirror: true,
    offset: 50
});

// Initialize Swiper (unchanged from original)
const testimonialSwiper = new Swiper('.testimonials-slider', {
    slidesPerView: 1,
    spaceBetween: 30,
    loop: true,
    autoplay: {
        delay: 3000,
        disableOnInteraction: false,
    },
    pagination: {
        el: '.swiper-pagination',
        clickable: true,
    },
    breakpoints: {
        640: {
            slidesPerView: 2,
        },
        1024: {
            slidesPerView: 3,
        },
    }
});

// Enhanced Navbar Scroll Effect
const navbar = document.querySelector('.navbar');
let lastScroll = 0;

window.addEventListener('scroll', () => {
    const currentScroll = window.pageYOffset;

    // Add/remove scrolled class with smooth transition
    navbar.style.transition = 'all 0.3s ease';
    if (currentScroll > 50) {
        navbar.classList.add('scrolled');
        navbar.style.transform = 'translateY(0)';
    } else {
        navbar.classList.remove('scrolled');
    }

    // Hide/show navbar on scroll
    if (currentScroll > lastScroll && currentScroll > 500) {
        navbar.style.transform = 'translateY(-100%)';
    } else {
        navbar.style.transform = 'translateY(0)';
    }

    lastScroll = currentScroll;
});

// Enhanced Smooth Scroll
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        const target = document.querySelector(this.getAttribute('href'));
        if (target) {
            window.scrollTo({
                top: target.offsetTop - 80,
                behavior: 'smooth'
            });
            // Add active state to navbar items
            document.querySelectorAll('.nav-link').forEach(link => link.classList.remove('active'));
            this.classList.add('active');
        }
    });
});

// Enhanced Plan Card Hover Effects
document.querySelectorAll('.plan-card').forEach(card => {
    card.addEventListener('mouseenter', function() {
        this.style.transform = 'translateY(-15px) scale(1.02)';
        this.style.boxShadow = '0 20px 40px rgba(0,0,0,0.15)';
        // Animate price
        const price = this.querySelector('.price');
        if (price) {
            price.style.transform = 'scale(1.1)';
            price.style.color = '#2E7D32';
        }
    });

    card.addEventListener('mouseleave', function() {
        this.style.transform = 'translateY(0) scale(1)';
        this.style.boxShadow = '0 10px 30px rgba(0,0,0,0.1)';
        // Reset price animation
        const price = this.querySelector('.price');
        if (price) {
            price.style.transform = 'scale(1)';
            price.style.color = '';
        }
    });
});

// Parallax Scrolling Effects
window.addEventListener('scroll', () => {
    const scrolled = window.pageYOffset;

    // Parallax for hero background
    const heroBg = document.querySelector('.hero-bg');
    if (heroBg) {
        heroBg.style.transform = `translateY(${scrolled * 0.5}px)`;
    }

    // Parallax for images
    document.querySelectorAll('.floating').forEach(element => {
        const speed = element.dataset.speed || 0.3;
        element.style.transform = `translateY(${scrolled * speed}px)`;
    });
});

// Interactive Button Effects
document.querySelectorAll('.btn').forEach(button => {
    button.addEventListener('mouseenter', function() {
        this.style.transform = 'translateY(-3px) scale(1.05)';
        this.style.boxShadow = '0 10px 20px rgba(76, 175, 80, 0.3)';
    });

    button.addEventListener('mouseleave', function() {
        this.style.transform = 'translateY(0) scale(1)';
        this.style.boxShadow = '';
    });

    button.addEventListener('click', function() {
        this.style.transform = 'scale(0.95)';
        setTimeout(() => {
            this.style.transform = '';
        }, 200);
    });
});

// Number Counter Animation
function animateCounter(element, start, end, duration = 2000) {
    let startTimestamp = null;
    const step = (timestamp) => {
        if (!startTimestamp) startTimestamp = timestamp;
        const progress = Math.min((timestamp - startTimestamp) / duration, 1);
        element.innerHTML = Math.floor(progress * (end - start) + start);
        if (progress < 1) {
            window.requestAnimationFrame(step);
        }
    };
    window.requestAnimationFrame(step);
}

// Trigger counter animations when elements are in view
const counterObserver = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            const element = entry.target;
            const end = parseInt(element.dataset.count);
            animateCounter(element, 0, end);
            counterObserver.unobserve(element);
        }
    });
}, { threshold: 0.5 });

document.querySelectorAll('[data-count]').forEach(counter => {
    counterObserver.observe(counter);
});

// Enhanced Mobile Menu
const mobileMenuBtn = document.querySelector('.navbar-toggler');
const navbarCollapse = document.querySelector('.navbar-collapse');

mobileMenuBtn.addEventListener('click', () => {
    mobileMenuBtn.classList.toggle('active');
    navbarCollapse.classList.toggle('show');

    // Add slide animation
    if (navbarCollapse.classList.contains('show')) {
        navbarCollapse.style.transform = 'translateX(0)';
        navbarCollapse.style.opacity = '1';
    } else {
        navbarCollapse.style.transform = 'translateX(-100%)';
        navbarCollapse.style.opacity = '0';
    }
});

// Cursor Animation
const cursor = document.createElement('div');
cursor.classList.add('custom-cursor');
document.body.appendChild(cursor);

document.addEventListener('mousemove', (e) => {
    cursor.style.left = e.clientX + 'px';
    cursor.style.top = e.clientY + 'px';
});

// Enhanced hover effects for interactive elements
document.querySelectorAll('a, button, .plan-card, .feature-item').forEach(element => {
    element.addEventListener('mouseenter', () => {
        cursor.classList.add('cursor-hover');
        cursor.style.transform = 'translate(-50%, -50%) scale(1.5)';
    });

    element.addEventListener('mouseleave', () => {
        cursor.classList.remove('cursor-hover');
        cursor.style.transform = 'translate(-50%, -50%) scale(1)';
    });
});

// Add loading animation to buttons
document.querySelectorAll('.btn').forEach(button => {
    button.addEventListener('click', function() {
        if (!this.classList.contains('loading')) {
            this.classList.add('loading');
            const originalText = this.innerHTML;
            this.innerHTML = '<span class="spinner"></span>';

            setTimeout(() => {
                this.classList.remove('loading');
                this.innerHTML = originalText;
            }, 1500);
        }
    });
});

// Feature cards tilt effect
document.querySelectorAll('.benefit-card').forEach(card => {
    card.addEventListener('mousemove', (e) => {
        const rect = card.getBoundingClientRect();
        const x = e.clientX - rect.left;
        const y = e.clientY - rect.top;

        const centerX = rect.width / 2;
        const centerY = rect.height / 2;

        const angleX = (y - centerY) / 20;
        const angleY = (centerX - x) / 20;

        card.style.transform = `perspective(1000px) rotateX(${angleX}deg) rotateY(${angleY}deg) scale3d(1.02, 1.02, 1.02)`;
    });

    card.addEventListener('mouseleave', () => {
        card.style.transform = 'perspective(1000px) rotateX(0) rotateY(0) scale3d(1, 1, 1)';
    });
});

// Add ripple effect to buttons
document.querySelectorAll('.btn').forEach(button => {
    button.addEventListener('click', function(e) {
        const ripple = document.createElement('span');
        ripple.classList.add('ripple');
        this.appendChild(ripple);

        const rect = this.getBoundingClientRect();
        const size = Math.max(rect.width, rect.height);

        ripple.style.width = ripple.style.height = `${size}px`;
        ripple.style.left = `${e.clientX - rect.left - size/2}px`;
        ripple.style.top = `${e.clientY - rect.top - size/2}px`;

        ripple.addEventListener('animationend', () => {
            ripple.remove();
        });
    });
});


// Intersection Observer for scroll animations 
const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            entry.target.classList.add('animate-fadeInUp');
        }
    });
}, {
    threshold: 0.1
});

// Observe elements for animation
document.querySelectorAll('.plan-card, .feature-item').forEach((element) => {
    observer.observe(element);
});

// Close mobile menu when clicking outside
document.addEventListener('click', (e) => {
    if (!navbarCollapse.contains(e.target) && !mobileMenuBtn.contains(e.target)) {
        navbarCollapse.classList.remove('show');
        mobileMenuBtn.classList.remove('active');
    }
});

// Add loading animation to buttons (from edited code, similar to original but more concise)
document.querySelectorAll('.btn').forEach(button => {
    button.addEventListener('click', function() {
        this.classList.add('loading');
        // Simulate loading state
        setTimeout(() => {
            this.classList.remove('loading');
        }, 1000);
    });
});

// Dynamic counter animation for numbers 
function animateValue(obj, start, end, duration) {
    let startTimestamp = null;
    const step = (timestamp) => {
        if (!startTimestamp) startTimestamp = timestamp;
        const progress = Math.min((timestamp - startTimestamp) / duration, 1);
        obj.innerHTML = Math.floor(progress * (end - start) + start);
        if (progress < 1) {
            window.requestAnimationFrame(step);
        }
    };
    window.requestAnimationFrame(step);
}