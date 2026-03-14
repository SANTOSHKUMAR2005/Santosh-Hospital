/* ================= ADMIN LOGIN ================= */

const adminBox = document.getElementById("Admin");
const adminTitle = adminBox.querySelector("h3");
const adminForm = adminBox.querySelector("form");

adminTitle.style.cursor = "pointer";

// Show form on click
adminTitle.addEventListener("click", () => {
    adminForm.style.display = "block";
});

// Hide form when mouse leaves admin box
adminBox.addEventListener("mouseleave", () => {
    adminForm.style.display = "none";
});
 

/* ================= DOCTORS DROPDOWN ================= */

const doctorLink = document.getElementById("doc");
const doctorTypes = document.getElementById("doctorTypes");

// Prevent page reload
doctorLink.addEventListener("click", (e) => {
    e.preventDefault();
});

// Show dropdown on hover
doctorLink.addEventListener("mouseenter", () => {
    doctorTypes.style.display = "flex";
});

// Keep dropdown open when hovering over it
doctorTypes.addEventListener("mouseenter", () => {
    doctorTypes.style.display = "flex";
});

// Hide dropdown when mouse leaves both
doctorLink.addEventListener("mouseleave", () => {
    setTimeout(() => {
        if (!doctorTypes.matches(":hover")) {
            doctorTypes.style.display = "none";
        }
    }, 150);
});

doctorTypes.addEventListener("mouseleave", () => {
    doctorTypes.style.display = "none";
});




