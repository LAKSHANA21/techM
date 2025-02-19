function generateOtp() {
    document.getElementById('otpFields').style.display = 'flex';
    document.getElementById('verifyButtonContainer').style.display = 'block';
    document.getElementById('getOtpButton').disabled = true; 
    alert('OTP has been sent to your mobile number.');
}

function verifyOtp() {
    const otp1 = document.getElementById('otp1').value;
    const otp2 = document.getElementById('otp2').value;
    const otp3 = document.getElementById('otp3').value;
    const otp4 = document.getElementById('otp4').value; 
    const otp = otp1 + otp2 + otp3 + otp4;
    if (otp.length === 4) {
        alert('OTP Verified');
        window.location.href = "plans.html";
    } else {
        alert('Please enter the full OTP.');
    }
}

 document.getElementById("other-method-btn").addEventListener("click", function() {
    document.getElementById("other-method-section").style.display = "block";
});


document.getElementById("gpay-btn").addEventListener("click", function() {
    alert("You have chosen to pay using GPay.");
    showPopup();
});

document.getElementById("payment-method").addEventListener("change", function() {
    var selectedMethod = this.value;
    document.querySelectorAll(".payment-option").forEach(function(option) {
        option.style.display = "none";
    });

    if (selectedMethod === "card") {
        document.getElementById("card-details").style.display = "block";
    } else if (selectedMethod === "wallet") {
        document.getElementById("wallet-details").style.display = "block";
    } else if (selectedMethod === "netbanking") {
        document.getElementById("netbanking-details").style.display = "block";
    } else if (selectedMethod === "emi") {
        document.getElementById("emi-details").style.display = "block";
    }
});

document.getElementById("proceed-btn").addEventListener("click", function() {
    showPopup();
});

function showPopup() {
    document.getElementById("success-popup").style.display = "block";
}

function closePopup() {
    document.getElementById("success-popup").style.display = "none";
}
