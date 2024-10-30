// Load theme from localStorage
document.addEventListener("DOMContentLoaded", () => {
  const savedTheme = localStorage.getItem("theme");
  if (savedTheme) {
    document.body.classList.remove("light", "dark");
    document.body.classList.add(savedTheme);
    const themeToggleButton = document.getElementById("themeToggle");
    themeToggleButton.innerHTML =
      savedTheme === "light"
        ? '<i class="fas fa-sun"></i> Switch to Dark Mode'
        : '<i class="fas fa-moon"></i> Switch to Light Mode';
  }
});
// ---------------WORD TO PDF START--------------------
async function convertWordToPdf() {
  const fileInput = document.getElementById("wordFile");
  if (!fileInput.files.length) {
    Swal.fire("Error", "Please select a Word file first.", "error");
    return;
  }

  const formData = new FormData();
  formData.append("file", fileInput.files[0]);
  const loader = document.getElementById("loaderWord");
  loader.style.display = "block"; // Show loader

  const response = await fetch("/api/converter/word/pdf", {
    method: "POST",
    body: formData,
  });

  if (response.ok) {
    const blob = await response.blob();
    const convertedFileName =
      fileInput.files[0].name.replace(/\.[^/.]+$/, "") + ".pdf"; // Retain original name
    const url = window.URL.createObjectURL(blob);
    const downloadButton = document.getElementById("downloadButtonWord");
    downloadButton.href = url;
    downloadButton.style.display = "inline";
    downloadButton.download = convertedFileName; // Set original name for download
    Swal.fire("Success", "Word file converted successfully!", "success");
  } else {
    Swal.fire("Error", "Failed to convert file. Please try again.", "error");
  }
  loader.style.display = "none"; // Hide loader
}
// ---------------WORD TO PDF END--------------------

// ---------------PDF TO WORD START------------------
async function convertPdfToWord() {
  const fileInput = document.getElementById("pdfFile");
  if (!fileInput.files.length) {
    Swal.fire("Error", "Please select a PDF file first.", "error");
    return;
  }

  const formData = new FormData();
  formData.append("file", fileInput.files[0]);
  const loader = document.getElementById("loaderPdf");
  loader.style.display = "block"; // Show loader

  const response = await fetch("/api/converter/pdf/word", {
    method: "POST",
    body: formData,
  });
  if (response.ok) {
    const blob = await response.blob();
    const convertedFileName =
      fileInput.files[0].name.replace(/\.[^/.]+$/, "") + ".docx"; // Retain original name
    const url = window.URL.createObjectURL(blob);
    const downloadButton = document.getElementById("downloadButtonPdf");
    downloadButton.href = url;
    downloadButton.style.display = "inline";
    downloadButton.download = convertedFileName; // Set original name for download
    Swal.fire("Success", "PDF file converted successfully!", "success");
  } else if (response.status == 413) {
    Swal.fire("Error", "size issue", "error");
  } else {
    Swal.fire("Error", "Failed to convert file. Please try again.", "error");
  }
  loader.style.display = "none"; // Hide loader
}
// ---------------PDF TO WORD END------------------

// ---------------WORD TO HTML START------------------
async function convertWordToHTML() {
  const fileInput = document.getElementById("wordToTextFile");
  if (!fileInput.files.length) {
    Swal.fire("Error", "Please select a Word file first.", "error");
    return;
  }

  const formData = new FormData();
  formData.append("file", fileInput.files[0]);
  const loader = document.getElementById("loaderWordText");
  loader.style.display = "block"; // Show loader

  const response = await fetch("/api/converter/word/text", {
    method: "POST",
    body: formData,
  });
  if (response.ok) {
    const blob = await response.blob();
    const convertedFileName =
      fileInput.files[0].name.replace(/\.[^/.]+$/, "") + ".txt"; // Retain original name
    const url = window.URL.createObjectURL(blob);
    const downloadButton = document.getElementById("downloadButtonWordText");
    downloadButton.href = url;
    downloadButton.style.display = "inline";
    downloadButton.download = convertedFileName; // Set original name for download
    Swal.fire("Success", "Word file converted successfully!", "success");
  } else if (response.status == 413) {
    Swal.fire("Error", "size issue", "error");
  } else {
    Swal.fire("Error", "Failed to convert file. Please try again.", "error");
  }
  loader.style.display = "none"; // Hide loader
}
// ---------------WORD TO HTML END------------------
// ---------------WORD TO JPEG START--------------------
async function convertWordToJpeg() {
  const fileInput = document.getElementById("wordJpegFile");
  if (!fileInput.files.length) {
    Swal.fire("Error", "Please select a Word file first.", "error");
    return;
  }

  const formData = new FormData();
  formData.append("file", fileInput.files[0]);
  const loader = document.getElementById("loaderWordJpeg");
  loader.style.display = "block"; // Show loader

  const response = await fetch("/api/converter/word/jpeg", {
    method: "POST",
    body: formData,
  });
  if (response.ok) {
    const blob = await response.blob();
    const convertedFileName =
      fileInput.files[0].name.replace(/\.[^/.]+$/, "") + ".jpeg"; // Retain original name
    const url = window.URL.createObjectURL(blob);
    const downloadButton = document.getElementById("downloadButtonWordJpeg");
    downloadButton.href = url;
    downloadButton.style.display = "inline";
    downloadButton.download = convertedFileName; // Set original name for download
    Swal.fire("Success", "Word file converted successfully!", "success");
  } else if (response.status == 413) {
    Swal.fire("Error", "size issue", "error");
  } else {
    Swal.fire("Error", "Failed to convert file. Please try again.", "error");
  }
  loader.style.display = "none"; // Hide loader
}
// ---------------WORD TO JPEG END--------------------

// ---------------PDF TO EXCEL START--------------------
async function convertPdfToExcel() {
  const fileInput = document.getElementById("pdfExcelFile");
  if (!fileInput.files.length) {
    Swal.fire("Error", "Please select a Word file first.", "error");
    return;
  }

  const formData = new FormData();
  formData.append("file", fileInput.files[0]);
  const loader = document.getElementById("loaderPdfExcel");
  loader.style.display = "block"; // Show loader

  const response = await fetch("/api/converter/pdf/excel", {
    method: "POST",
    body: formData,
  });
  if (response.ok) {
    const blob = await response.blob();
    const convertedFileName =
      fileInput.files[0].name.replace(/\.[^/.]+$/, "") + ".xlsx"; // Retain original name
    const url = window.URL.createObjectURL(blob);
    const downloadButton = document.getElementById("downloadButtonPdfExcel");
    downloadButton.href = url;
    downloadButton.style.display = "inline";
    downloadButton.download = convertedFileName; // Set original name for download
    Swal.fire("Success", "PDF file converted successfully!", "success");
  } else if (response.status == 413) {
    Swal.fire("Error", "size issue", "error");
  } else {
    Swal.fire("Error", "Failed to convert file. Please try again.", "error");
  }
  loader.style.display = "none"; // Hide loader
}
// ---------------PDF TO EXCEL END--------------------

// ---------------PDF TO POWERPOINT START--------------------
async function convertPdfToPowerPoint() {
  const fileInput = document.getElementById("pdfPPTFile");
  if (!fileInput.files.length) {
    Swal.fire("Error", "Please select a Word file first.", "error");
    return;
  }

  const formData = new FormData();
  formData.append("file", fileInput.files[0]);
  const loader = document.getElementById("loaderPdfPPT");
  loader.style.display = "block"; // Show loader

  const response = await fetch("/api/converter/pdf/powerpoint", {
    method: "POST",
    body: formData,
  });
  if (response.ok) {
    const blob = await response.blob();
    const convertedFileName =
      fileInput.files[0].name.replace(/\.[^/.]+$/, "") + ".pptx"; // Retain original name
    const url = window.URL.createObjectURL(blob);
    const downloadButton = document.getElementById("downloadButtonPdfPPT");
    downloadButton.href = url;
    downloadButton.style.display = "inline";
    downloadButton.download = convertedFileName; // Set original name for download
    Swal.fire("Success", "PDF file converted successfully!", "success");
  } else if (response.status == 413) {
    Swal.fire("Error", "size issue", "error");
  } else {
    Swal.fire("Error", "Failed to convert file. Please try again.", "error");
  }
  loader.style.display = "none"; // Hide loader
}
// ---------------PDF TO POWERPOINT END--------------------

function home() {
  window.location.href = "/";
}
function moreOption() {
  window.location.href = "/more";
}

// Theme toggle functionality
const themeToggleButton = document.getElementById("themeToggle");
themeToggleButton.addEventListener("click", () => {
  const currentTheme = document.body.classList.contains("dark")
    ? "dark"
    : "light";
  const newTheme = currentTheme === "dark" ? "light" : "dark";
  document.body.classList.toggle("dark");
  document.body.classList.toggle("light");
  themeToggleButton.innerHTML =
    newTheme === "light"
      ? '<i class="fas fa-sun"></i> Switch to Dark Mode'
      : '<i class="fas fa-moon"></i> Switch to Light Mode';
  localStorage.setItem("theme", newTheme); // Save new theme to localStorage
});
