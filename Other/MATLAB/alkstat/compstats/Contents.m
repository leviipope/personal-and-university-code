% Computational Statistics Toolbox.
% Version 1.0 (R12)     26-Sep-2001
%
% From the book 'Computational Statistics Handbook with MATLAB' by
%   Wendy and Angel Martinez, CRC Press, Sep 2001.
%   
% For more information on these functions, type helpwin
%   at the command line and select this toolbox.
% 
% Distributions.
%  Probability Density (Mass) Functions.
%   csbetap     - Beta distribution.
%   csbinop     - Binomial distribution.
%   cschip      - Chi-square distribution.
%   csexpop     - Exponential distribution.
%   csgammp     - Gamma distribution.
%   csnormp     - Normal distribution - univariate.
%   csevalnorm  - Normal distribution - multivariate.
%   cspoisp     - Poisson distribution.
%   csunifp     - Continuous uniform distribution.
%   csweibp     - Weibull distribution.
%
%  Cumulative Distribution Functions.
%   csbetac     - Beta distribution.
%   csbinoc     - Binomial distribution.
%   cschic      - Chi-square distribution.
%   csexpoc     - Exponential distribution.
%   csgammc     - Gamma distribution.
%   csnormc     - Normal distribution - univariate.
%   cspoisc     - Poisson distribution.
%   csunifc     - Continuous uniform distribution.
%   csweibc     - Weibull distribution.
%
%  Parameter Estimation.
%   csbinpar    - Binomial distribution.
%   csexpar     - Exponential distribution.
%   csgampar    - Gamma distribution.
%   cspoipar    - Poisson distribution.
%   csunipar    - Continuous uniform distribution.
%
%  Quantiles - Inverse Cumulative Distribution.
%   csbinoq     - Binomial distribution.
%   csexpoq     - Exponential distribution.
%   csunifq     - Continuous uniform distribution.
%   csnormq     - Normal distribution - univariate.
%   csweibq     - Weibull distribution.
%   csquantiles - Returns the sample quantiles.
%
%  Statistics
%   csmomentc   - Sample central moments.
%   csmoment    - Sample moments.
%   cskewness   - Coefficient of skewness.
%   cskurtosis  - Coefficient of kurtosis - not excess kurtosis.
%   csecdf      - Empirical cumulative distribution function.
%
%  Random Number Generation
%   csbetarnd   - Beta distribution.
%   csbinrnd    - Binomial distribution.
%   cschirnd    - Chi-square distribution.
%   csdunrnd    - Discrete uniform distribution.
%   csexprnd    - Exponential distribution.
%   csgamrnd    - Gamma distribution.
%   csmvrnd     - Normal distribution - multivariate.
%   cspoirnd    - Poisson distribution.
%   cssphrnd    - Points on the unit sphere.
%
%  Exploratory Data Analysis
%   csstars     - Star plot.
%   csstemleaf  - Stem-and-leaf plot.
%   csparallel  - Parallel coordinates plot.
%   csqqplot    - Q-Q plot.
%   cspoissplot - Poissonness plot.
%   csandrews   - Andrews curves.
%   csexpoplot  - Exponential probability plot.
%   csbinoplot  - Binomial plot.
%   csppeda     - Projection pursuit exploratory data analysis.
%   csppind     - Projection pursuit index - chi-square.
%   csppstrtrem - Projection pursuit structure removal.
%
%  Bootstrap and Jackknife.
%   csboot      - Bootstrap of bias and standard error.
%   csbootint   - Bootstrap-t confidence interval.
%   csbooperint - Bootstrap percentile confidence interval.
%   csbootbca   - Bootstrap Bias-corrected and accelerated confidence interval.
%   csjack      - Jackknife estimate of bias and standard error
%   csjackboot  - Jackknife after bootstrap.
%
%  Probability Density Estimation.
%   cshist2d    - Bivariate density histogram.
%   cshistden   - Univariate density histogram.
%   csfreqpoly  - Frequency polygon density estimate.
%   csash       - Univariate averaged shifted histogram.
%   cskernmd    - Multivariate kernel density estimation.
%   cskern1d    - Univariate kernel density estimation.
%   cskern2d    - Bivariate kernel density estimation.
%   csdfplot    - dF representation of the mixture parameter space.
%   csplotuni   - Plot a univariate finite mixture density.
%   csfinmix    - Univariate & multivariate finite mixture density estimation.
%   csadpmix    - Univariate & multivariate adaptive mixture density estimation.
%
%  Classification Trees.
%   csgrowc     - Grow a classification tree.
%   csprunec    - Prune a classification tree.
%   cstreec     - Classify an observation using a tree.
%   csplotreec  - Plot a classification tree.
%   cspicktreec - Extract a tree from the sequence of pruned trees.
%
%  Statistical Pattern Recognition.
%   cshmeans    - K-means clustering.
%   cskmeans    - K-means clustering.
%   csrocgen    - Generate ROC curve.
%   cskernmd    - Estimate class-conditional densities.
%   cskern2d    - Estimate bivariate class-conditional densities.
%
%  Nonparametric Regression.
%   csloess     - Loess smoothing.
%   csloessenv  - Loess smoothing with upper and lower smooths.
%   csloessr    - Robust loess smoothing.
%   cslocpoly   - Local polynomial smoothing.
%   csloclin    - Local linear regression.
%   csnardwats  - Nardarya-Watson regression.
%
%  Regression Trees.
%   csgrowr     - Grow a regression tree.
%   cspruner    - Prune a regression tree.
%   cstreer     - Return function estimate using a tree.
%   csplotreer  - Plot a regression tree.
%   cspicktreer - Extract a tree from the sequence of pruned trees.
%
%  Markov Chain Monte Carlo.
%   csgelrub    - Gelman-Rubin convergence diagnostic.
%   csmcmcdemo  - Demo of the Metropolis-Hastings sampler.
%
%  Spatial Statistics.
%   csbinproc       - Generate binomial spatial point process.
%   csclustproc     - Generate cluster spatial point process.
%   csinhibproc     - Generate regular spatial point process.
%   cspoissproc     - Generate Poisson spatial point process.
%   csstraussproc   - Generate a Strauss spatial point process.
%   csgetregion     - Interactively set a study region.
%   csintkern       - Estimate intensity using kernels.
%   csfhat          - Estimate the F distribution function.
%   csghat          - Estimate the G distribution function.
%   cskhat          - Estimate the K function.
%