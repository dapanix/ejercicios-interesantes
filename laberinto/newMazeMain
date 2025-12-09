import os
import time
from laberinto4 import mapa
import random

class Node:
    listaFrontera=[]
    def __init__(self, posx, posy, clave):
        self.clave = clave
        self.posx = posx
        self.posy = posy
        

    def getposx(self):
         return self.posx
    def getposy(self):
         return self.posy

    def getNombre(self):
         return self.clave
    def getlistaFrontera(self):
         calcularFrontera(self)
         return self.listaFrontera
    
    
    
altoMapa=len(mapa)
anchoMapa=len(mapa[1])
listaNodos=[]

#~funcion para que el algoritmo sepa desde que punto sale
def escanearPuntos(salida):
     global salidax, saliday, finalx, finaly
     for i in range(len(mapa)):  
        for j in range(len(mapa[i])):
             if mapa[i][j]==salida:
                    saliday=i
                    salidax=j



#metodo para calcular todas las posiciones disponibles a los que se puede mover el algoritmo
#desde un nodo
def calcularFrontera(nodo :Node):
     nodo.listaFrontera.clear()
     for i in listaNodos:
               if (i.posx == nodo.posx and (i.posy == nodo.posy + 1 or i.posy == nodo.posy - 1)) or \
               (i.posy == nodo.posy and (i.posx == nodo.posx + 1 or i.posx == nodo.posx - 1)):
                    if mapa[i.posy][i.posx] == " " or mapa[i.posy][i.posx]=="B":
                        nodo.listaFrontera.append(i) 


#funcion para crear un objeto node para cada elemento del laberinto
def asignarValores():
          cont=0
          for i in range(anchoMapa):
               for j in range(altoMapa):
                         cont+=1
                         clave =Node(i,j,cont)
                         listaNodos.append(clave)
asignarValores()
escanearPuntos("A")
listaNodosRecorridos=[]
MAX_ITERACIONES=400
cont=0

for i in listaNodos:
     if i.getposx()==salidax and i.getposy()==saliday:   
          nodoActual=i

          
def mostrarmapa():
    os.system('cls' if os.name == 'nt' else 'clear')  # <-- limpia la consola
    for i in range(len(mapa)):  
        print("".join(mapa[i]))  # <-- para que se vea como un laberinto real

while cont < MAX_ITERACIONES:
#-escanear frontera
#-Hay casilla/s libre/s?
#si si: mover a una aleatoriamente
#si no: ir a la ultima casilla con casillas disponibles

     cont+=1
     calcularFrontera(nodoActual)
     rand=False
     if len(nodoActual.getlistaFrontera())>0:#si tiene frontera disponible
          #elegir celda random 
          rand=True
          if len(nodoActual.getlistaFrontera())>1:
               ran = random.randint(0, len(nodoActual.getlistaFrontera())-1)
          else:
               ran=0
          seleccionado=nodoActual.listaFrontera[ran]   
     else:
          for i in reversed(listaNodosRecorridos):
               if len(i.getlistaFrontera())>0:
                    nodoActual=i
                    break
     
     if rand:
          nodoActual=seleccionado
          listaNodosRecorridos.append(nodoActual)
     else:
          listaNodosRecorridos.remove(nodoActual)
          listaNodosRecorridos.append(nodoActual)

     if mapa[nodoActual.getposy()][nodoActual.getposx()]=="B":
          print("ALGORITMO TERMINADO")
          print("MOVIMIENTOS REALIZADOS: "+str(cont))
          break
     else:
          mapa[nodoActual.getposy()][nodoActual.getposx()]="*"
     mostrarmapa()
     time.sleep(0.03)


