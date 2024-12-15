// Function to generate input fields for profits and weights
function generateInputs() {
    const numItems = document.getElementById('num-items').value;
    const weightsContainer = document.getElementById('weights');
    const profitsContainer = document.getElementById('profits');

    // Clear previous inputs
    weightsContainer.innerHTML = '';
    profitsContainer.innerHTML = '';

    for (let i = 0; i < numItems; i++) {
        // Create profit input
        const profitInput = document.createElement('input');
        profitInput.type = 'number';
        profitInput.className = 'profit';
        profitInput.placeholder = `P${i + 1}`;

        // Create weight input
        const weightInput = document.createElement('input');
        weightInput.type = 'number';
        weightInput.className = 'weight';
        weightInput.placeholder = `W${i + 1}`;

        profitsContainer.appendChild(profitInput);
        weightsContainer.appendChild(weightInput);
    }
}

// Function to calculate the knapsack result
function calculateKnapsack() {
    const numItems = parseInt(document.getElementById('num-items').value);
    const capacity = parseInt(document.getElementById('capacity').value);

    const profits = [];
    const weights = [];

    const profitInputs = document.querySelectorAll('.profit');
    const weightInputs = document.querySelectorAll('.weight');

    for (let i = 0; i < numItems; i++) {
        const profit = parseInt(profitInputs[i].value);
        const weight = parseInt(weightInputs[i].value);

        // Validate input values
        if (isNaN(profit) || isNaN(weight)) {
            alert("Please enter valid numbers for all profits and weights.");
            return;
        }

        profits.push(profit);
        weights.push(weight);
    }

    // Initialize the DP table
    const dp = Array(numItems + 1).fill(0).map(() => Array(capacity + 1).fill(0));

    // Fill DP table
    for (let i = 1; i <= numItems; i++) {
        for (let w = 0; w <= capacity; w++) {
            if (weights[i - 1] <= w) {
                dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + profits[i - 1]);
            } else {
                dp[i][w] = dp[i - 1][w];
            }
        }
    }

    // Display maximum profit
    const resultDiv = document.getElementById('result');
    resultDiv.innerHTML = `Maximum Profit: ${dp[numItems][capacity]}`;

    // Backtrack to find the items included
    let w = capacity;
    const itemsIncluded = [];
    for (let i = numItems; i > 0 && w > 0; i--) {
        if (dp[i][w] !== dp[i - 1][w]) {
            itemsIncluded.push(`Item ${i}`);
            w -= weights[i - 1];
        }
    }

    // Display the items in the sack
    const sackItemsList = document.getElementById('sack-items-list');
    sackItemsList.innerHTML = '';
    itemsIncluded.reverse().forEach(item => {
        const li = document.createElement('li');
        li.textContent = item;
        sackItemsList.appendChild(li);
    });

    // Generate the DP table for visualization
    let tableHTML = '<table><tr><th>Item / Weight</th>';
    for (let w = 0; w <= capacity; w++) {
        tableHTML += `<th>${w}</th>`;
    }
    tableHTML += '</tr>';

    for (let i = 0; i <= numItems; i++) {
        tableHTML += `<tr><th>Item ${i}</th>`;
        for (let w = 0; w <= capacity; w++) {
            tableHTML += `<td>${dp[i][w]}</td>`;
        }
        tableHTML += '</tr>';
    }
    tableHTML += '</table>';

    document.getElementById('dp-table').innerHTML = tableHTML;
}

// Smooth scroll to form
document.querySelector('.visualize-button').addEventListener('click', function () {
    document.getElementById('form').scrollIntoView({ behavior: 'smooth' });
});
