const path = require('path');

module.exports = {
    mode: "production",
    entry: ['./js/index.js'],
    output: {
        path: path.resolve(__dirname, 'resources/public/js/libs'),
        filename: 'bundle.js',
        clean: true,
    },
    module: {
        rules: [
            {
                test: /\.m?js/,
                resolve: {
                    fullySpecified: false,
                }
            },
            {
                test: /\.css$/,
                use: ['style-loader', 'css-loader']
            }
        ]
    },
};
