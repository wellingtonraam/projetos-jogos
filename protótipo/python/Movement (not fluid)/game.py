import sys, pygame

### author: Wellington Ramos || email: wellingtonraam@gmail.com


### Inicialize the game ###
pygame.init()

### screen size and name ###

size = width, height = 640, 480
screen = pygame.display.set_mode(size)
pygame.display.set_caption("Character movement")

### fps ###
clock = pygame.time.Clock()

### test if playing ###
playing = True

### colors ###
white = 255, 255, 255
purple = 142, 68, 173

### Point x and y of the screen ###
py = 0
px = 0


### functions to draw player ###
def player(x, y):
    pygame.draw.rect(screen, purple, pygame.Rect(x, y, 40, 40))



### Game loop ###
while playing:
    ### Keyboard Event Listener ###
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            playing = False
            sys.exit()

        if event.type == pygame.KEYDOWN:
            pressed = True
            if event.key == pygame.K_UP:
                py += 10
            if event.key == pygame.K_DOWN:
                py -= 10
            if event.key == pygame.K_LEFT:
                px += 10
            if event.key == pygame.K_RIGHT:
                px -= 10


    ### clean screen ###
    screen.fill(white)
    ### Create player (rectangle for collision) ###
    y = (240 - (20 + py))
    x = (320 - (20 + px))
    ### draw player ###
    player(x, y)
    ### Refresh screen ###
    pygame.display.flip()
    clock.tick(60)