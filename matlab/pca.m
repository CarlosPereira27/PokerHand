% ----------------------------------------------------------------------
% Universidade de São Paulo (USP)
% Instituto de Ciências Matemáticas e de Computação (ICMC)
% SCC0251 - Processamento de Imagens - 2013/1
% Prof. Dr. Mario Gazziro
% Monitor PAE: Vinicius Ruela Pereira Borges
%
% AULA 10: Redução de Dimensionalidade
% CÓDIGO: Dimensionality Reduction - Principal Component Analysis (PCA)
%         Redução de Dimensionalidade - Análise de Componentes Principais
% =========================================================
% Código adaptado para dados PokerHand


function [signals,PC,V] = pca
    
    % Definicao dataset / Dataset definition
    dataBruto = readtable('../data/poker-hand-testing.csv', ...
        'ReadVariableNames', false);
    dataBruto = table2array(dataBruto);
    data = dataBruto(:,1:10);
    %data = [2 3;3 4;4 5;5 6;5 7;2 1;3 2;4 2;4 3;6 4;7 6];
    
    % Classes
    c = dataBruto(:,11);
    
    % Monta vetores binários com as classes
    c0 = data(find(c==0),:);
    c1 = data(find(c==1),:);
    c2 = data(find(c==2),:);
    c3 = data(find(c==3),:);
    c4 = data(find(c==4),:);
    c5 = data(find(c==5),:);
    c6 = data(find(c==6),:);
    c7 = data(find(c==7),:);
    c8 = data(find(c==8),:);
    c9 = data(find(c==9),:);
    
    % Plota os dados
    figure;

    p0 = plot(c0(:,1), c0(:,2), c0(:,3), c0(:,4), c0(:,5), c0(:,6), c0(:,7), c0(:,8), c0(:,9), c0(:,10),'ro', 'markersize',10, 'linewidth', 3); hold on;
    p1 = plot(c1(:,1), c1(:,2), c1(:,3), c1(:,4), c1(:,5), c1(:,6), c1(:,7), c1(:,8), c1(:,9), c1(:,10), 'go', 'markersize',10, 'linewidth', 3); hold on;
    p2 = plot(c2(:,1), c2(:,2), c2(:,3), c2(:,4), c2(:,5), c2(:,6), c2(:,7), c2(:,8), c2(:,9), c2(:,10), 'bo', 'markersize',10, 'linewidth', 3); hold on;
    p3 = plot(c3(:,1), c3(:,2), c3(:,3), c3(:,4), c3(:,5), c3(:,6), c3(:,7), c3(:,8), c3(:,9), c3(:,10), 'wo', 'markersize',10, 'linewidth', 3); hold on;
    p4 = plot(c4(:,1), c4(:,2), c4(:,3), c4(:,4), c4(:,5), c4(:,6), c4(:,7), c4(:,8), c4(:,9), c4(:,10), 'ko', 'markersize',10, 'linewidth', 3); hold on;
    p5 = plot(c5(:,1), c5(:,2), c5(:,3), c5(:,4), c5(:,5), c5(:,6), c5(:,7), c5(:,8), c5(:,9), c5(:,10), 'yo', 'markersize',10, 'linewidth', 3); hold on;
    p6 = plot(c6(:,1), c6(:,2), c6(:,3), c6(:,4), c6(:,5), c6(:,6), c6(:,7), c6(:,8), c6(:,9), c6(:,10), 'mo', 'markersize',10, 'linewidth', 3); hold on;
    p7 = plot(c7(:,1), c7(:,2), c7(:,3), c7(:,4), c7(:,5), c7(:,6), c7(:,7), c7(:,8), c7(:,9), c7(:,10), 'co', 'markersize',10, 'linewidth', 3); hold on;
    p8 = plot(c8(:,1), c8(:,2), c8(:,3), c8(:,4), c8(:,5), c8(:,6), c8(:,7), c8(:,8), c8(:,9), c8(:,10), 'o', 'color', [0.9412 0.4706 0], 'markersize',10, 'linewidth', 3); hold on;
    p9 = plot(c9(:,1), c9(:,2), c9(:,3), c9(:,4), c9(:,5), c9(:,6), c9(:,7), c9(:,8), c9(:,9), c9(:,10), 'o', 'color', [0.251 0 0.502], 'markersize',10, 'linewidth', 3);


    xlim([0 14]);
    ylim([0 14]);
    
    % Pega dimensão dos dados
    [N,d] = size(data);

    % Calcula a média dos dados
    mu = mean(data);
    
    % Centraliza os dados na origem (0,0)
    Phi(1:N,1:d) = 0;
    for i = 1:N
        for j = 1:d
            Phi(i,j) = data(i,j) - mu(j);
        end
    end
    
    % Calcula a covariância
    C = (1/N).*((Phi')*Phi);
    
    % Determina os autovalores e autovetores da matriz de covariancia
    % autovalores D and autovetores V
    [V,D] = eig(C);
    writetable(array2table(D), 'autovalores.csv');
    writetable(array2table(V), 'autovetores.csv');
    
    % ordena os autovalores em ordem decrescente
    [D, k] = sort(diag(D), 'descend');
    V = V(:,k);
    
    %Fator de escala
    escala =5;
    
    % Monta a componente principal
    pc0_0 = line([mu(1) - escala * V(1,1) ; mu(1) + escala * V(1,1)], [mu(2) - escala * V(2,1) ; mu(2) + escala * V(2,1)]);
    pc0_1 = line([mu(1) - escala * V(1,1) ; mu(1) + escala * V(1,1)], [mu(3) - escala * V(2,1) ; mu(2) + escala * V(2,1)]);
    pc0_2 = line([mu(1) - escala * V(1,1) ; mu(1) + escala * V(1,1)], [mu(4) - escala * V(2,1) ; mu(2) + escala * V(2,1)]);
    pc0_3 = line([mu(1) - escala * V(1,1) ; mu(1) + escala * V(1,1)], [mu(2) - escala * V(2,1) ; mu(2) + escala * V(2,1)]);
    pc0_4 = line([mu(1) - escala * V(1,1) ; mu(1) + escala * V(1,1)], [mu(2) - escala * V(2,1) ; mu(2) + escala * V(2,1)]);
    pc1 = line([mu(1) - escala * V(1,2) ; mu(1) + escala * V(1,2)], [mu(2) - escala * V(2,2) ; mu(2) + escala * V(2,2)]);
    pc2 = line([mu(1) - escala * V(1,3) ; mu(1) + escala * V(1,3)], [mu(2) - escala * V(2,3) ; mu(2) + escala * V(2,3)]);
    pc3 = line([mu(1) - escala * V(1,4) ; mu(1) + escala * V(1,4)], [mu(2) - escala * V(2,4) ; mu(2) + escala * V(2,4)]);
    pc4 = line([mu(1) - escala * V(1,5) ; mu(1) + escala * V(1,5)], [mu(2) - escala * V(2,5) ; mu(2) + escala * V(2,5)]);
    pc5 = line([mu(1) - escala * V(1,6) ; mu(1) + escala * V(1,6)], [mu(2) - escala * V(2,6) ; mu(2) + escala * V(2,6)]);
    pc6 = line([mu(1) - escala * V(1,7) ; mu(1) + escala * V(1,7)], [mu(2) - escala * V(2,7) ; mu(2) + escala * V(2,7)]);
    pc7 = line([mu(1) - escala * V(1,8) ; mu(1) + escala * V(1,8)], [mu(2) - escala * V(2,8) ; mu(2) + escala * V(2,8)]);
    pc8 = line([mu(1) - escala * V(1,9) ; mu(1) + escala * V(1,9)], [mu(2) - escala * V(2,9) ; mu(2) + escala * V(2,9)]);
    pc9 = line([mu(1) - escala * V(1,10) ; mu(1) + escala * V(1,10)], [mu(2) - escala * V(2,10) ; mu(2) + escala * V(2,10)]);
	
    
    % Projeta os pontos no componente principal
    z = Phi*V(:,1);
    
    %Reconstroi o eixo
    p = z*V(:,1)';
    [ps_1,ps_2] = size(p);
    
    for i = 1:ps_1
        for j = 1:ps_2
            p(i,j) = p(i,j) + mu(j);
        end
    end
    hold off;
    % delete old plots
    %delete(p1);delete(p2);
    y0 = p(find(c==0),:);
    y1 = p(find(c==1),:);
    y2 = p(find(c==2),:);
    y3 = p(find(c==3),:);
    y4 = p(find(c==4),:);
    y5 = p(find(c==5),:);
    y6 = p(find(c==6),:);
    y7 = p(find(c==7),:);
    y8 = p(find(c==8),:);
    y9 = p(find(c==9),:);
    figure;
    p0 = plot(y0(:,1),y0(:,2),y0(:,3),y0(:,4),y0(:,5),y0(:,6),y0(:,7),y0(:,8),y0(:,9),y0(:,10),'ro', 'markersize', 10, 'linewidth', 3);hold on;
    p1 = plot(y1(:,1),y1(:,2),y1(:,3),y1(:,4),y1(:,5),y1(:,6),y1(:,7),y1(:,8),y1(:,9),y1(:,10),'go', 'markersize', 10, 'linewidth', 3); hold on;
    p2 = plot(y2(:,1),y2(:,2),y2(:,3),y2(:,4),y2(:,5),y2(:,6),y2(:,7),y2(:,8),y2(:,9),y2(:,10),'bo', 'markersize', 10, 'linewidth', 3); hold on;
    p3 = plot(y3(:,1),y3(:,2),y3(:,3),y3(:,4),y3(:,5),y3(:,6),y3(:,7),y3(:,8),y3(:,9),y3(:,10),'wo', 'markersize', 10, 'linewidth', 3); hold on;
    p4 = plot(y4(:,1),y4(:,2),y4(:,3),y4(:,4),y4(:,5),y4(:,6),y4(:,7),y4(:,8),y4(:,9),y4(:,10),'ko', 'markersize', 10, 'linewidth', 3); hold on;
    p5 = plot(y5(:,1),y5(:,2),y5(:,3),y5(:,4),y5(:,5),y5(:,6),y5(:,7),y5(:,8),y5(:,9),y5(:,10),'yo', 'markersize', 10, 'linewidth', 3); hold on;
    p6 = plot(y6(:,1),y6(:,2),y6(:,3),y6(:,4),y6(:,5),y6(:,6),y6(:,7),y6(:,8),y6(:,9),y6(:,10),'mo', 'markersize', 10, 'linewidth', 3); hold on;
    p7 = plot(y7(:,1),y7(:,2),y7(:,3),y7(:,4),y7(:,5),y7(:,6),y7(:,7),y7(:,8),y7(:,9),y7(:,10),'co', 'markersize', 10, 'linewidth', 3); hold on;
    p8 = plot(y8(:,1),y8(:,2),y8(:,3),y8(:,4),y8(:,5),y8(:,6),y8(:,7),y8(:,8),y8(:,9),y8(:,10),'o','color',[0.9412 0.4706 0],  'markersize', 10, 'linewidth', 3); hold on;
    p9 = plot(y9(:,1),y9(:,2),y9(:,3),y9(:,4),y9(:,5),y9(:,6),y9(:,7),y9(:,8),y9(:,9),y9(:,10),'o','color', [0.251 0 0.502],'markersize', 10, 'linewidth', 3); hold on;

    set(pc0, 'color', 'r', 'linestyle', '--')
    set(pc1, 'color', 'g', 'linestyle', '--')
    set(pc2, 'color', 'b', 'linestyle', '--')
    set(pc3, 'color', 'w', 'linestyle', '--')
    set(pc4, 'color', 'k', 'linestyle', '--')
    set(pc5, 'color', 'y', 'linestyle', '--')
    set(pc6, 'color', 'm', 'linestyle', '--')
    set(pc7, 'color', 'c', 'linestyle', '--')
    set(pc8, 'color', [0.9412 0.4706 0], 'linestyle', '--')
    set(pc9, 'color', [0.251 0 0.502], 'linestyle', '--')

    
end
