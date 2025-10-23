from laberinto2 import mapa 
import random
import time
import sys
import os  # <-- para limpiar la consola

fronterax = []
fronteray = []
primera = True
cont = 0


class Node:
    def __init__(self, posx, posy):
        self.posx = posx
        self.posy = posy
        self.fronteraX = calcularFronteraX(posx, posy)
        self.fronteraY = calcularFronteraY(posx, posy)

    def getposx(self):
         return self.posx
    def getposy(self):
         return self.posy
    def getfrontX(self):
         return self.fronteraX
    def getfrontY(self):
         return self.fronteraY
    

def calcularFronteraX(posx, posy):  
    fronteraX = []
    for i in range(len(mapa)):
        for j in range(len(mapa[i])):  
           if (i== posy and (j==posx+1 or j==posx-1))or \
            (j==posx and  (i==posy+1 or i==posy-1)):
               if mapa[i][j] == " " or mapa[i][j]=="B":
                    fronteraX.append(j)
    return fronteraX  

def calcularFronteraY(posx, posy):  
    fronteraY = []
    for i in range(len(mapa)):  
        for j in range(len(mapa[i])):  
            if (j == posx and (i == posy + 1 or i == posy - 1)) or \
               (i == posy and (j == posx + 1 or j == posx - 1)):
                if mapa[i][j] == " " or mapa[i][j]=="B":
                    fronteraY.append(i)
    return fronteraY  


def crearCelda(frontX,frontY):
    clave_celda_actual = f"celda{cont}"
    if len(frontX)>1 and len(frontY)>1:
        ran = random.randint(0, len(frontX) - 1)
    else:
         ran=0
    celdas[clave_celda_actual] = Node(frontX[ran], frontY[ran])
    print(f"Se ha creado {clave_celda_actual} en ({celdas[clave_celda_actual].posx}, {celdas[clave_celda_actual].posy})")
    mapa[celdas[clave_celda_actual].posy][celdas[clave_celda_actual].posx] = "*"
    
    

def mostrarmapa():
    os.system('cls' if os.name == 'nt' else 'clear')  # <-- limpia la consola
    for i in range(len(mapa)):  
        print("".join(mapa[i]))  # <-- para que se vea como un laberinto real

def recorrerFronteras():
    for i in range(len(celdas) - 1, -1, -1): 
        clave = f"celda{i}" 
        if clave in celdas and celdas[clave].fronteraX and celdas[clave].fronteraY:
            frontX=calcularFronteraX(celdas[clave].getposx(), celdas[clave].getposy())
            frontY=calcularFronteraY(celdas[clave].getposx(), celdas[clave].getposy())
            if frontX and frontY:
                crearCelda(frontX,frontY)  

def escanearPuntos(salida, final):
     global salidax, saliday, finalx, finaly
     for i in range(len(mapa)):  
        for j in range(len(mapa[i])):
             if mapa[i][j]==salida:
                    saliday=i
                    salidax=j
     for i in range(len(mapa)):  
        for j in range(len(mapa[i])):
            if mapa[i][j]==final:
                    finalx=j
                    finaly=i
escanearPuntos("A","B")

MAX_ITERACIONES=400
celdas = {}  
final=Node(finalx,finaly)
while cont < MAX_ITERACIONES:
    if primera: 
        celdas["celda0"] = Node(salidax,saliday)  
        primera = False
    else:
        if f"celda{cont - 1}" in celdas:
            fronterax = celdas[f"celda{cont - 1}"].fronteraX
            fronteray = celdas[f"celda{cont - 1}"].fronteraY
            
            if fronterax and fronteray:
                crearCelda(fronterax,fronteray)
            else:
                 recorrerFronteras()

    mostrarmapa()
    time.sleep(0.2)  # <-- añade retraso entre pasos (ajusta el tiempo si quieres)
    if f"celda{cont}" in celdas:
        if celdas[f"celda{cont}"].posx ==final.posx and celdas[f"celda{cont}"].posy ==final.posy:
            print("SOLUCION ENCONTRADA")
            print("numero de casillas ocupadas: "+str(cont))
            sys.exit()
    
    cont += 1
