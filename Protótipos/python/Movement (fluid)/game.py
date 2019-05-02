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


### Listener Keyboard Events ###
pressed = True
controlkey = [False, False, False, False]
key = pygame.K_UP


### Checking which key was pressed and changing the character's x or y point ###
def check_keys_py(py):
    if controlkey[0]:
        py += 1
    if controlkey[1]:
        py -= 1
    return py


def check_keys_px(px):
    if controlkey[2]:
        px += 1
    if controlkey[3]:
        px -= 1
    return px


### Game loop ###
while playing:
    ### Keyboard Event Listener ###
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            playing = False
            sys.exit()
        if event.type == pygame.KEYUP:
            pressed = False
            if event.key == pygame.K_UP:
                controlkey[0] = pressed
            if event.key == pygame.K_DOWN:
                controlkey[1] = pressed
            if event.key == pygame.K_LEFT:
                controlkey[2] = pressed
            if event.key == pygame.K_RIGHT:
                controlkey[3] = pressed
        if event.type == pygame.KEYDOWN:
            pressed = True
            if event.key == pygame.K_UP:
                controlkey[0] = pressed
            if event.key == pygame.K_DOWN:
                controlkey[1] = pressed
            if event.key == pygame.K_LEFT:
                controlkey[2] = pressed
            if event.key == pygame.K_RIGHT:
                controlkey[3] = pressed
        
    py = check_keys_py(py)
    px = check_keys_px(px)

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